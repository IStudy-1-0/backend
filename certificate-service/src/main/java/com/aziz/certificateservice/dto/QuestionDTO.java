package com.aziz.certificateservice.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

public class QuestionDTO {
    private String label;
    @JsonBackReference
    private List<AnswerDTO> answers;

    // Getters and setters
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<AnswerDTO> getResponses() {
        return answers;
    }

    public void setResponses(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
