package com.techbeyondjava.exammode_service.service.impl;

import com.techbeyondjava.exammode_service.dao.QuestionDao;
import com.techbeyondjava.exammode_service.dto.QuestionDto;
import com.techbeyondjava.exammode_service.dto.QuestionsCriteria;
import com.techbeyondjava.exammode_service.model.Question;
import com.techbeyondjava.exammode_service.service.QuestionService;
import com.techbeyondjava.exammode_service.util.Util;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private static final Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Autowired
    QuestionDao questionDao;

    @Autowired
    HttpSession httpSession;

    @Override
    public List<QuestionDto> getExamModeQuestions(QuestionsCriteria questionsCriteria) {
        logger.info("Called getAllQuestions...{}####@ = {}", questionsCriteria, Util.passNullIfAll(questionsCriteria.getDifficultyLevel()));
        List<Question> questionList = questionDao.getExamModeQuestions(Util.passNullIfAll(questionsCriteria.getTopic()), Util.passNullIfAll(questionsCriteria.getDifficultyLevel()), questionsCriteria.getNoOfQuestions());
        logger.info("Questions from DB : {}",questionList);
        httpSession.setAttribute("questionList", questionList);
        return extractDataForFrontEnd(questionList);
    }

    private List<QuestionDto> extractDataForFrontEnd(List<Question> questionList) {
        List<QuestionDto> questionDtoList = questionList.stream().map(eachQuestion-> new QuestionDto(eachQuestion.getSerialNo(),
                                                                                                     eachQuestion.getQuestion(),
                                                                                                     eachQuestion.getOption1(),
                                                                                                     eachQuestion.getOption2(),
                                                                                                     eachQuestion.getOption3(),
                                                                                                     eachQuestion.getOption4(),
                                                                                                    null,
                                                                                                    null))
                                                                                                    .collect(Collectors.toList());

        logger.info("Questions to UI : {}", questionDtoList);
        return questionDtoList;
    }


}
