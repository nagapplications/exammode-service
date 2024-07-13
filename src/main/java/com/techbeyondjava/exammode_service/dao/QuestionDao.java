package com.techbeyondjava.exammode_service.dao;

import com.techbeyondjava.exammode_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    @Query(value = "SELECT ROW_NUMBER() OVER () AS serial_no,id,question,option1,option2,option3,option4,right_answer,topic,difficulty_level FROM (SELECT * FROM question where (:topic is null or topic=:topic) and (:difficultyLevel is null or difficulty_level=:difficultyLevel) order by RAND() LIMIT :noOfQuestions) question_view", nativeQuery = true)
    List<Question> getExamModeQuestions(String topic, String difficultyLevel, Integer noOfQuestions);
}
