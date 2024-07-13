package com.techbeyondjava.exammode_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDtoWrapper implements Serializable {

    private List<QuestionDto> questionDtoList;
    private String scorePercentageStatus;
}
