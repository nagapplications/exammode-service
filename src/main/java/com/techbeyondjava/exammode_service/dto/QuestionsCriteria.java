package com.techbeyondjava.exammode_service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class QuestionsCriteria implements Serializable {
    private String topic;
    private Integer noOfQuestions;
    private String difficultyLevel;
}
