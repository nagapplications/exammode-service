package com.techbeyondjava.exammode_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class QuestionDto implements Serializable {

    private long id;
    private String Question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
