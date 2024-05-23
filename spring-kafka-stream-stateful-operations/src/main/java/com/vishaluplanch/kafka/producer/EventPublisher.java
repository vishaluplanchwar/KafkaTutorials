package com.vishaluplanch.kafka.producer;

import com.vishaluplanch.kafka.avro.schema.StockOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class EventPublisher {

    @Value("${stock.stateful.ops.topic}")
    private String stock_topic;


    @Autowired
    private KafkaTemplate<Long, StockOrders> stockOrdersKafkaTemplate;

    private Random random = new Random();

    @GetMapping(value = "/generateEvents")
    public void publish() throws InterruptedException {
        STOCKS[] stocks = STOCKS.values();
        for (int i = 0; i < 150; i++) {
            long key = random.longs(9999, 99999999).findAny().getAsLong();
            if (i % 2 == 0)
                stockOrdersKafkaTemplate.send(stock_topic, key, generateBuyStockOrder(key, stocks[i % 10].name, stocks[i % 10].price, "BUY"));
            else
                stockOrdersKafkaTemplate.send(stock_topic, key, generateBuyStockOrder(key, stocks[i % 10].name, stocks[i % 10].price, "SELL"));
        }
    }

    private StockOrders generateBuyStockOrder(long id, String stock, Double price, String type) {
        StockOrders orders = StockOrders.newBuilder().build();
        orders.setStockId(id);
        orders.setStockName(stock);
        orders.setOrderPrice(price);
        orders.setOrderType(type);
        orders.setOrderQuantity(id);
        orders.setTotalOrderAmount(id * price);
        orders.setExchange("NSE");
        return orders;
    }
}
