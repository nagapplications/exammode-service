package com.techbeyondjava.exammode_service.controller;

import com.techbeyondjava.exammode_service.dto.QuestionDto;
import com.techbeyondjava.exammode_service.dto.QuestionDtoWrapper;
import com.techbeyondjava.exammode_service.dto.QuestionsCriteria;
import com.techbeyondjava.exammode_service.model.Question;
import com.techbeyondjava.exammode_service.service.QuestionService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowedHeaders = "*", allowCredentials = "true")
public class QuestionController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    QuestionService questionService;

    @Autowired
    HttpSession httpSession;

    @PostMapping("/getExamModeQuestions")
    public List<QuestionDto> getExamModeQuestions(@RequestBody QuestionsCriteria questionsCriteria) {
        logger.info("Called getExamModeQuestions, questionsCriteria : {}", questionsCriteria);
        if (httpSession.getAttribute("questionsCriteria") == null) {
            httpSession.setAttribute("questionsCriteria", questionsCriteria);
        }

        return questionService.getExamModeQuestions(questionsCriteria);
    }


    @PostMapping("/evaluateExam")
    public QuestionDtoWrapper evaluateExam(@RequestBody List<QuestionDto> questionDtoList) {
        logger.info("Called evaluateExam, questionDtoList : {}", questionDtoList);
        //TODO : MOVE CODE TO SERVICE
        int rightAnswerCount = 0;
        List<Question> questionList = (List<Question>) httpSession.getAttribute("questionList");

        Iterator<Question> questionListItr = questionList.iterator();
        Iterator<QuestionDto> questionDtoListItr = questionDtoList.iterator();
        List<QuestionDto> evaludatedQuestionDtoList = new ArrayList<>();
        while (questionListItr.hasNext() && questionDtoListItr.hasNext()) {
            Question questionItem = questionListItr.next();
            QuestionDto questionDtoItem = questionDtoListItr.next();
            BeanUtils.copyProperties(questionItem, questionDtoItem);
            evaludatedQuestionDtoList.add(questionDtoItem);

            if (questionItem.getSerialNo() == questionDtoItem.getSerialNo() &&
                    questionItem.getRightAnswer().equalsIgnoreCase(questionDtoItem.getChoosenAnswer())) {
                rightAnswerCount += 1;
            }
        }
        logger.info("Evaluated QuestionDtoList {}", evaludatedQuestionDtoList);

        QuestionDtoWrapper questionDtoWrapper = new QuestionDtoWrapper();
        questionDtoWrapper.setQuestionDtoList(evaludatedQuestionDtoList);
        String score = String.format("SCORE = %s out of %s,  PERCENTAGE = %s", rightAnswerCount, questionList.size(), Math.round(((float) rightAnswerCount / questionList.size()) * 100));
        logger.info("SCORE = {}",score);
        questionDtoWrapper.setScorePercentageStatus(score);


        return questionDtoWrapper;
    }

}
