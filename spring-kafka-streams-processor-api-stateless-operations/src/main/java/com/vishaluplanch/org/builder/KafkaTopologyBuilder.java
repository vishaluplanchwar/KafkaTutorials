package com.vishaluplanch.org.builder;

import com.vishaluplanch.org.processor.CollateralEnrichedProcessor;
import com.vishaluplanch.org.processor.EmploymentEnrichedProcessor;
import com.vishaluplanch.org.schemas.CollateralEnrichedDetail;
import com.vishaluplanch.org.schemas.EmploymentEnrichedDetail;
import com.vishaluplanch.org.schemas.LoanDetail;
import com.vishaluplanch.org.topics.Topic;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class KafkaTopologyBuilder {

    @Autowired
    private StreamsBuilder streamsBuilder;

    @Autowired
    private KafkaProperties kafkaProperties;
    @Autowired
    private Topic<Long, LoanDetail> loanDetailTopic;
    @Autowired
    private Topic<Long, CollateralEnrichedDetail> collateralEnrichedDetailTopic;
    @Autowired
    private Topic<Long, EmploymentEnrichedDetail> employmentEnrichedDetailTopic;

    @PostConstruct
    public void build() {
        Topology topology = streamsBuilder.build();
        topology.addSource("SOURCE", loanDetailTopic.getKeySerde().deserializer(), loanDetailTopic.getValueSerde().deserializer(), loanDetailTopic.getTopicName()).
                addProcessor("COLLATERAL", CollateralEnrichedProcessor::new, "SOURCE").
                addProcessor("EMPLOYMENT", EmploymentEnrichedProcessor::new, "SOURCE").
                addSink("COLLATERAL-SINK", collateralEnrichedDetailTopic.getTopicName(), collateralEnrichedDetailTopic.getKeySerde().serializer(), collateralEnrichedDetailTopic.getValueSerde().serializer(), "COLLATERAL")
                .addSink("EMPLOYMENT-SINK", employmentEnrichedDetailTopic.getTopicName(), employmentEnrichedDetailTopic.getKeySerde().serializer(), employmentEnrichedDetailTopic.getValueSerde().serializer(), "EMPLOYMENT");

        KafkaStreams streaming = new KafkaStreams(topology, new StreamsConfig(kafkaProperties.buildStreamsProperties()));
        streaming.start();
    }
}
