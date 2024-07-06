package com.techbeyondjava.exammode_service.dto;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class ExamModeDto {
    Map<String, String> qstnAnswers;
}
