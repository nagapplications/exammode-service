package com.techbeyondjava.exammode_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto implements Serializable {

    private long serialNo;
    private String Question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String choosenAnswer;
    private String rightAnswer;
}
