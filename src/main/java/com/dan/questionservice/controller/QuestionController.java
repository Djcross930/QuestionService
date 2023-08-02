package com.dan.questionservice.controller;
import com.dan.questionservice.model.Question;
import com.dan.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            return questionService.getAllQuestions();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        try {
            return questionService.getQuestionsByCategory(category);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        try {
            return questionService.addQuestion(question);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new String("Something Went Wrong!"), HttpStatus.BAD_REQUEST);
    }


    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsFromQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions)
    {
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }
    //generate
    //getquestions (questionid)
    //getscore
}
