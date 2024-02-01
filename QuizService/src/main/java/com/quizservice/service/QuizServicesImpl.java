package com.quizservice.service;

import com.quizservice.entity.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.quizservice.repository.QuizRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizServicesImpl implements QuizServices{

    private QuizRepository quizRepository;

    private QuestionClient questionClient;


    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getOneQuiz(Long id) {
        Quiz quiz=quizRepository.findById(id).orElseThrow(()->new RuntimeException("quiz not found"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }

    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> quizzes=quizRepository.findAll();
        List<Quiz> newQuizList= quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }
}
