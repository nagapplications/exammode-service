package com.techbeyondjava.exammode_service.service;

import com.techbeyondjava.exammode_service.dto.QuestionDto;
import com.techbeyondjava.exammode_service.dto.QuestionsCriteria;

import java.util.List;


public interface QuestionService {
    List<QuestionDto> getExamModeQuestions(QuestionsCriteria questionsCriteria);

}
