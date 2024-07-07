package com.techbeyondjava.exammode_service.dao;

import com.techbeyondjava.exammode_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    @Query(value = "SELECT q FROM Question q where (:topic is null or q.topic=:topic) and (:difficultyLevel is null or q.difficultyLevel=:difficultyLevel) order by RAND() LIMIT :noOfQuestions")
    List<Question> getExamModeQuestions(String topic, String difficultyLevel, Integer noOfQuestions);
}
