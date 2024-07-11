package com.techbeyondjava.exammode_service.controller;

import com.techbeyondjava.exammode_service.dto.QuestionDto;
import com.techbeyondjava.exammode_service.dto.QuestionsCriteria;
import com.techbeyondjava.exammode_service.model.Question;
import com.techbeyondjava.exammode_service.service.QuestionService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public List<Question> evaluateExam(@RequestBody Map<Integer, String> qstnAnsMap) {
        logger.info("Called evaluateExam, examModeDto : {}", qstnAnsMap);
        Map<Integer, Long> storedQstnMap = (Map<Integer, Long>) httpSession.getAttribute("qstnNumMap");

        int rightAnswerCount = 0;
        String result = "";
        for (Map.Entry<Integer, String> entry : qstnAnsMap.entrySet()) {
            Integer qstnNo = entry.getKey();
            String optionChoosen = entry.getValue();

            Long storedQstnNo = storedQstnMap.get(qstnNo);

            List<Question> storedQuestionDtoList = (List<Question>) httpSession.getAttribute("questionList");
            Optional<Question> questionOpt = storedQuestionDtoList.stream().filter(e -> e.getId() == storedQstnNo.intValue()).findFirst();
            Question question = questionOpt.get();
            if (question.getRightAnswer().equalsIgnoreCase(optionChoosen)) {
                ++rightAnswerCount;
            }
            //logger.info("QstNo : {}, OptionChoosen : {} is a {}", qstnNo, optionChoosen, (question.getRightAnswer().equalsIgnoreCase(optionChoosen)) ? "Right Answer" : "Wrong Answer, Right Answer is : " + question.getRightAnswer());
            result = rightAnswerCount + "/" + storedQstnMap.size();


        }
        logger.info("SCORE = {}, PERCENTAGE = {}%", result, Math.round(((float) rightAnswerCount / storedQstnMap.size()) * 100));

        return null;
    }

}