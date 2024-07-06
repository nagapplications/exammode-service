package com.techbeyondjava.exammode_service.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class QuestionDto {

    private long id;
    private String Question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String difficultyLevel;
    private String rightAnswer;
    private String topic;
    private Date createdDate;
    private Date modifiedDate;
}
