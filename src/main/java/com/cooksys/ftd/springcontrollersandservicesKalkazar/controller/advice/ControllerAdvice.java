package com.cooksys.ftd.springcontrollersandservicesKalkazar.controller.advice;

import javax.naming.InvalidNameException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cooksys.ftd.springcontrollersandservicesKalkazar.exceptions.*;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(CouldNotAddQuizException.class)
	public ResponseMessage couldNotAddQuiz(CouldNotAddQuizException e) {
		return new ResponseMessage(e.getMessage());
	}
	
	@ExceptionHandler(InvalidQuestionException.class)
	public ResponseMessage invalidQuestion(InvalidQuestionException e) {
		return new ResponseMessage(e.getMessage());
	}
	
	@ExceptionHandler(QuestionNotFoundException.class)
	public ResponseMessage questionNotFound(QuestionNotFoundException e) {
		return new ResponseMessage(e.getMessage());
	}
	
	@ExceptionHandler(QuizNotFoundException.class)
	public ResponseMessage quizNotFound(QuizNotFoundException e) {
		return new ResponseMessage(e.getMessage());
	}
	
	@ExceptionHandler(InvalidNameException.class)
	public ResponseMessage invalidName(InvalidNameException e) {
		return new ResponseMessage(e.getMessage());
	}
	
}
