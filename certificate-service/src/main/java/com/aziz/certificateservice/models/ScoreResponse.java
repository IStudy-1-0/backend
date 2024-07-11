package com.aziz.certificateservice.models;

public class ScoreResponse {
    private int score;

    public ScoreResponse(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
