package com.vishaluplanch.kafka.stateful.ops.aggregate;

import com.vishaluplanch.kafka.avro.schema.StockOrders;
import com.vishaluplanch.kafka.avro.schema.StockPriceSumAndCount;
import com.vishaluplanch.kafka.utils.SerdeConfigUtil;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RunningAveragePrice {

    @Value("${stock.stateful.ops.topic}")
    private String stock_topic;

    @Autowired
    private StreamsBuilder streamsBuilder;

    @Autowired
    private SerdeConfigUtil serdeConfigUtil;

    @PostConstruct
    public void runningBuyAvgPrice() {

        //TODO: STEP-1 : Create stream on stock order events topic
        KStream<Long, StockOrders> stockOrdersKStream = this.getKStreamOfStockOrders();

        //TODO: STEP-2 : Filter events by orderType=BUY, Group events by stock name. Like StockName-> Stock Order Events
        KGroupedStream<String, StockOrders> stockOrdersKGroupedStream = stockOrdersKStream.filter((key, value) -> value.getOrderType().toString().equals("BUY")).
                groupBy((key, value) -> value.getStockName().toString().toUpperCase(), Grouped.with(Serdes.String(), serdeConfigUtil.registerStockOrders()));

        //TODO: STEP-3 : Apply aggregation on grouped stream. Count the number of events, calculate sum of order price and aggregate result in StockPriceSumAndCount avro schema
        KTable<String, StockPriceSumAndCount> sumAndCountKTable = stockOrdersKGroupedStream.aggregate(() -> StockPriceSumAndCount.newBuilder().build(), (stockName, stockOrder, sumAndCount) -> {
            StockPriceSumAndCount avro = StockPriceSumAndCount.newBuilder().build();
            avro.setCount(sumAndCount.getCount() + 1);
            avro.setSum(sumAndCount.getSum() + stockOrder.getOrderPrice());
            return avro;
        }, Materialized.with(Serdes.String(), serdeConfigUtil.registerStockPriceSumAndCount()));
        //TODO: STEP-4 : Apply mapValues operation on aggregate result & find out running avg price
        sumAndCountKTable.mapValues((stockName, sumAndCount) -> sumAndCount.getSum() / sumAndCount.getCount()).toStream().
                peek((stockName, avgPrice) -> log.info("Avg Price for {} is {}", stockName, avgPrice));

    }

    private KStream<Long, StockOrders> getKStreamOfStockOrders() {
        return streamsBuilder.stream(stock_topic, Consumed.with(Serdes.Long(), serdeConfigUtil.registerStockOrders()));
    }

}
