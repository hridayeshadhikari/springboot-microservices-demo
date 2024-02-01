package com.quizservice.service;

import com.quizservice.entity.Quiz;

import java.util.List;

public interface QuizServices {
    Quiz addQuiz(Quiz quiz);
    Quiz getOneQuiz(Long id);
    List<Quiz> getAllQuiz();
}
