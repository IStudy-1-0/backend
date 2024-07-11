package com.aziz.certificateservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class QuizDTO {
    private String title;
    @JsonIgnore
    private List<QuestionDTO> questions;

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
