package com.vishaluplanch.kafka.model;

import java.util.List;

public class MatchSummary {
    private long matchNum;
    private String stadium;
    private String location;
    private String matchDate;
    private String Team1;
    private String Team2;
    private String winner;
    private String result;
    private List<Score> team1Scores;
    private List<Score> team2Scores;

    public long getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(long matchNum) {
        this.matchNum = matchNum;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getTeam1() {
        return Team1;
    }

    public void setTeam1(String team1) {
        Team1 = team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public void setTeam2(String team2) {
        Team2 = team2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Score> getTeam1Scores() {
        return team1Scores;
    }

    public void setTeam1Scores(List<Score> team1Scores) {
        this.team1Scores = team1Scores;
    }

    public List<Score> getTeam2Scores() {
        return team2Scores;
    }

    public void setTeam2Scores(List<Score> team2Scores) {
        this.team2Scores = team2Scores;
    }
}


