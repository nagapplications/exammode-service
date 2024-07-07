package com.techbeyondjava.exammode_service.controller;

import com.techbeyondjava.exammode_service.dto.QuestionDto;
import com.techbeyondjava.exammode_service.dto.QuestionsCriteria;
import com.techbeyondjava.exammode_service.model.Question;
import com.techbeyondjava.exammode_service.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
public class QuestionController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    QuestionService questionService;

    @PostMapping("/getExamModeQuestions")
    public List<QuestionDto> getExamModeQuestions(@RequestBody QuestionsCriteria questionsCriteria) {
        logger.info("Called getExamModeQuestions, questionsCriteria : {}", questionsCriteria);
        return questionService.getExamModeQuestions(questionsCriteria);
    }


    @PostMapping("/evaluateExam")
    public List<Question> evaluateExam(@RequestBody Map<String, String> qstnAnsMap) {
        logger.info("Called evaluateExam, examModeDto : {}", qstnAnsMap);

        return null;
    }

}
