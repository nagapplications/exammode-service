package com.techbeyondjava.exammode_service.service;

import com.techbeyondjava.exammode_service.dto.QuestionDto;
import com.techbeyondjava.exammode_service.dto.QuestionsCriteria;
import com.techbeyondjava.exammode_service.model.Question;

import java.util.List;


public interface QuestionService {
    List<Question> getExamModeQuestions(QuestionsCriteria questionsCriteria);

}
