package com.questionservice.repository;

import com.questionservice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    //custom finder method
    List<Question> findByQuizId(Long quizId);
}
