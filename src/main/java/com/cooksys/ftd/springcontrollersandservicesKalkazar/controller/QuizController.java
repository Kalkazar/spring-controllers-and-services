package com.cooksys.ftd.springcontrollersandservicesKalkazar.controller;

import java.util.Map;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.springcontrollersandservicesKalkazar.exceptions.InvalidQuestionException;
import com.cooksys.ftd.springcontrollersandservicesKalkazar.exceptions.QuestionNotFoundException;
import com.cooksys.ftd.springcontrollersandservicesKalkazar.exceptions.QuizNotFoundException;
import com.cooksys.ftd.springcontrollersandservicesKalkazar.service.Question;
import com.cooksys.ftd.springcontrollersandservicesKalkazar.service.Quiz;
import com.cooksys.ftd.springcontrollersandservicesKalkazar.service.QuizService;

@RestController
public class QuizController {
	
	private QuizService quizService;
	
	@Autowired
	public QuizController(QuizService quizService) {
		super();
		this.quizService = quizService;
	}
	
	@GetMapping("quiz")
	public Map<String, Quiz> getQuizzes() {
		return this.quizService.getQuizzes();
	}
	
	@PostMapping("quiz")
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		return this.quizService.addQuiz(quiz);
	}
	
	@GetMapping("quiz/{quizName}")
	public Quiz getQuiz(@PathVariable("quizName") String quizName)
			throws QuizNotFoundException {
		return this.quizService.getQuiz(quizName);
	}
	
	@DeleteMapping("quiz/{quizName}")
	public Quiz deleteQuiz(@PathVariable("quizName") String quizName)
			throws QuizNotFoundException {
		return this.quizService.deleteQuiz(quizName);
	}
	
	@PatchMapping("quiz/{quizName}/rename/{newName}")
	public Quiz renameQuiz(@PathVariable("quizName") String quizName, @PathVariable("newName") String newName)
			throws QuizNotFoundException, InvalidNameException {
		return this.quizService.renameQuiz(quizName, newName);
	}
	
	@GetMapping("quiz/{quizName}/random")
	public Question randomQuizQuestion(@PathVariable("quizName") String quizName)
			throws QuizNotFoundException {
		return this.quizService.randomQuizQuestion(quizName);
	}
	
	@PatchMapping("quiz/{quizName}/add")
	public Quiz addQuestionToQuiz(@PathVariable("quizName") String quizName, @RequestBody Question question)
			throws QuizNotFoundException, InvalidQuestionException {
		return this.quizService.addQuestionToQuiz(quizName, question);
	}
	
	@DeleteMapping("quiz/{quizName}/delete/{question}")
	public Question deleteQuestionFromQuiz(@PathVariable("quizName") String quizName, @PathVariable("question") String questionId)
			throws QuizNotFoundException, QuestionNotFoundException {
		return this.quizService.deleteQuestionFromQuiz(quizName, questionId);
	}
	
}
