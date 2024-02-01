package com.questionservice.service;

import com.questionservice.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestion();
    Question getOneQuestion(Long id);
    Question createQuestion(Question question);

    List<Question> questionByQuizId(Long quizId);
}
