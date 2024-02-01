package com.quizservice.controller;

import com.quizservice.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.quizservice.service.QuizServices;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    public QuizServices quizServices;

    @GetMapping("/quizes")
    public List<Quiz> findAllTheQuiz(){
        return quizServices.getAllQuiz();
    }
    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable  Long id){
        return quizServices.getOneQuiz(id);
    }
    @PostMapping("/add")
    public Quiz createQuiz(@RequestBody Quiz quiz){
        return quizServices.addQuiz(quiz);
    }
}
