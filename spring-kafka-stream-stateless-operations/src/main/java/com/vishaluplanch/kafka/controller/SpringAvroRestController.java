package com.vishaluplanch.kafka.controller;

import com.vishaluplanch.kafka.model.MatchSummary;
import com.vishaluplanch.kafka.model.Score;
import com.vishaluplanch.kafka.producer.SpringAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SpringAvroRestController {

    @Autowired
    private SpringAvroProducer springAvroProducer;

    @PostMapping(value = "/matchSummary")
    public void matchSummary(@RequestBody MatchSummary summary) {
        com.vishaluplanch.kafka.schemas.MatchSummary schema = new com.vishaluplanch.kafka.schemas.MatchSummary();
        schema.setLocation(summary.getLocation());
        schema.setMatchDate(summary.getMatchDate());
        schema.setResult(summary.getResult());
        schema.setStadium(summary.getStadium());
        schema.setMatchNum(summary.getMatchNum());
        schema.setWinner(summary.getWinner());
        schema.setTeam1(summary.getTeam1());
        schema.setTeam2(summary.getTeam2());

        List<com.vishaluplanch.kafka.schemas.Score> scoreList = new ArrayList<>();
        for (Score score : summary.getTeam1Scores()) {
            com.vishaluplanch.kafka.schemas.Score score1 = new com.vishaluplanch.kafka.schemas.Score();
            score1.setPlayerName((CharSequence) score.getPlayerName());
            score1.setBallsPlayed(score.getBallsPlayed());
            score1.setRun(score.getRun());
            scoreList.add(score1);
        }
        schema.setTeam1Scores(scoreList);

        scoreList = new ArrayList<>();
        for (Score score : summary.getTeam2Scores()) {
            com.vishaluplanch.kafka.schemas.Score score2 = new com.vishaluplanch.kafka.schemas.Score();
            score2.setPlayerName(score.getPlayerName());
            score2.setBallsPlayed(score.getBallsPlayed());
            score2.setRun(score.getRun());
            scoreList.add(score2);
        }
        schema.setTeam2Scores(scoreList);


        springAvroProducer.send(schema);
    }
}
