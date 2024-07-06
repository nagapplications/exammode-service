package com.techbeyondjava.exammode_service.dto;

import lombok.Data;

@Data
public class QuestionsCriteria {
    private String topic;
    private Integer noOfQuestions;
    private String difficultyLevel;
}
