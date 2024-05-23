package com.vishaluplanch.kafka.stateful.ops.count;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StockCountStateStoreUtil {

    private final StreamsBuilderFactoryBean streamsBuilderFactoryBean;

    @Autowired
    public StockCountStateStoreUtil(StreamsBuilderFactoryBean streamsBuilderFactoryBean) {
        this.streamsBuilderFactoryBean = streamsBuilderFactoryBean;
    }

    public Long getCountByStockName(String stockName) {
        ReadOnlyKeyValueStore<String, Long> keyValueStore = this.initializeStore();
        return keyValueStore.get(stockName);
    }

    public List<KeyValue<String, Long>> getAllCountByStock() {
        List<KeyValue<String, Long>> list = new ArrayList<>();
        ReadOnlyKeyValueStore<String, Long> keyValueStore = this.initializeStore();
        KeyValueIterator<String, Long> keyValueIterator = keyValueStore.all();

        while (keyValueIterator.hasNext()) {
            list.add(keyValueIterator.next());
        }
        return list;
    }

    private ReadOnlyKeyValueStore<String, Long> initializeStore() {
        KafkaStreams kafkaStreams = streamsBuilderFactoryBean.getKafkaStreams();
        ReadOnlyKeyValueStore<String, Long> keyValueStore = kafkaStreams.store(StoreQueryParameters.fromNameAndType("COUNT_BY_STOCK", QueryableStoreTypes.keyValueStore()));
        return keyValueStore;
    }

}
