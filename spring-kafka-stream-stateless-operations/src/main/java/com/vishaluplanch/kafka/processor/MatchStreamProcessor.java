package com.vishaluplanch.kafka.processor;

import com.vishaluplanch.kafka.schemas.MatchSummary;
import com.vishaluplanch.kafka.schemas.Score;
import com.vishaluplanch.kafka.topics.Topic;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
public class MatchStreamProcessor {

    @Autowired
    private StreamsBuilder streamBuilder;

    @Autowired
    private Topic<Long, MatchSummary> matchSummaryTopic;

    @PostConstruct
    public void runStream() {


        KStream<Long, MatchSummary> kStream = streamBuilder.stream(matchSummaryTopic.getTopicName(), Consumed.with(matchSummaryTopic.getKeySerde(), matchSummaryTopic.getValueSerde()));
        /*kStream.filterNot((key, summary) -> summary.getLocation().toString().equals("Indore")).
                flatMapValues((key, value) -> value.getTeam1Scores()).
                peek((key, score) -> System.out.println("key : " + key + " value : " + score.toString()));*/

        kStream.filterNot((key, summary) -> summary.getLocation().toString().equals("Indore")).
                flatMap((KeyValueMapper<Long, MatchSummary, Iterable<? extends KeyValue<?, ?>>>) (aLong, summary) -> {
                    List<KeyValue<Long, Score>> result = new LinkedList<>();
                    int m = 2;
                    for (Score score : summary.getTeam1Scores()) {
                        result.add(new KeyValue<>(Long.valueOf(summary.getMatchNum() * m++), score));
                    }
                    return result;
                });
    }
}
