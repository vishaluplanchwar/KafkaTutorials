package com.vishaluplanch.kafka.stateful.ops.count;

import com.vishaluplanch.kafka.avro.schema.StockOrders;
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
public class StockCountProcessor {

    @Value("${stock.stateful.ops.topic}")
    private String stock_topic;

    @Autowired
    private StreamsBuilder streamsBuilder;

    @Autowired
    private SerdeConfigUtil serdeConfigUtil;


    public void countProcessor() {
        KStream<Long, StockOrders> stockOrdersKStream = streamsBuilder.stream(stock_topic, Consumed.with(Serdes.Long(), serdeConfigUtil.register(new SpecificAvroSerde<StockOrders>())));
        KTable<String, Long> count_by_stock = stockOrdersKStream.groupBy((key, value) -> value.getStockName().toString().toUpperCase(), Grouped.with(Serdes.String(), serdeConfigUtil.register(new SpecificAvroSerde<>()))).
                count(Materialized.as("COUNT_BY_STOCK"));
        count_by_stock.toStream().peek((key, value) -> log.info("Stock Name : {} And Count : {}", key, value));

    }

}
