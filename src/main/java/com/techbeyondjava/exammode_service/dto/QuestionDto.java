package com.techbeyondjava.exammode_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionDto {

    private long id;
    private String Question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
