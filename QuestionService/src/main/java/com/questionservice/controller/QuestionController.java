package com.questionservice.controller;

import com.questionservice.entity.Question;
import com.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public List<Question> findAllQuestion(){
        return questionService.getAllQuestion();
    }
    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }
    @GetMapping("/{quesId}")
    public Question findById(@PathVariable Long quesId){
        return questionService.getOneQuestion(quesId);
    }
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionByQuizId(@PathVariable Long quizId){
        return questionService.questionByQuizId(quizId);
    }
}
