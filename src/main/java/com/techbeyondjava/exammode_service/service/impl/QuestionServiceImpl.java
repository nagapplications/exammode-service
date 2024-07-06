package com.techbeyondjava.exammode_service.service.impl;

import com.techbeyondjava.exammode_service.dao.QuestionDao;
import com.techbeyondjava.exammode_service.dto.QuestionDto;
import com.techbeyondjava.exammode_service.dto.QuestionsCriteria;
import com.techbeyondjava.exammode_service.model.Question;
import com.techbeyondjava.exammode_service.service.QuestionService;
import com.techbeyondjava.exammode_service.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private static final Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Autowired
    QuestionDao questionDao;

    @Override
    public List<Question> getExamModeQuestions(QuestionsCriteria questionsCriteria) {
        logger.info("Called getAllQuestions...{}####@ = {}", questionsCriteria,Util.passNullIfAll(questionsCriteria.getDifficultyLevel()));
        return questionDao.getExamModeQuestions(Util.passNullIfAll(questionsCriteria.getTopic()), Util.passNullIfAll(questionsCriteria.getDifficultyLevel()), questionsCriteria.getNoOfQuestions());
    }


}
