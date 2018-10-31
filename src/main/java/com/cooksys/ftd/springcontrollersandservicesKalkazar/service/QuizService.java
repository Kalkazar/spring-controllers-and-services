package com.cooksys.ftd.springcontrollersandservicesKalkazar.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Service;

import com.cooksys.ftd.springcontrollersandservicesKalkazar.exceptions.InvalidQuestionException;
import com.cooksys.ftd.springcontrollersandservicesKalkazar.exceptions.QuestionNotFoundException;
import com.cooksys.ftd.springcontrollersandservicesKalkazar.exceptions.QuizNotFoundException;

@Service
public class QuizService {
	
	private Map<String, Quiz> quizzes = new HashMap<>();
	
	public QuizService() {
		Answer answerRight = new Answer('a', "correct answer", true);
		Answer answerWrong = new Answer('b', "incorrect answer", false);
		Answer answerEmpty = new Answer('c', "no answer given", false);
		Answer answeredBack = new Answer('d', "asked about question", true);
		
		Map<Character, Answer> firstAttempts = new HashMap<>();
		firstAttempts.put(answerRight.getAnswerId(), answerRight);
		
		Map<Character, Answer> secondAttempts = new HashMap<>();
		secondAttempts.put(answerRight.getAnswerId(), answerRight);
		secondAttempts.put(answerWrong.getAnswerId(), answerWrong);
		
		Map<Character, Answer> easyAttempts = new HashMap<>();
		easyAttempts.put(answerRight.getAnswerId(), answerRight);
		easyAttempts.put(answerWrong.getAnswerId(), answerWrong);
		easyAttempts.put(answerEmpty.getAnswerId(), answerEmpty);
		
		Map<Character, Answer> hardAttempts = new HashMap<>();
		hardAttempts.put(answerWrong.getAnswerId(), answerWrong);
		hardAttempts.put(answerEmpty.getAnswerId(), answerEmpty);
		hardAttempts.put(answeredBack.getAnswerId(), answeredBack);
		
		Question questionOne = new Question(1, "What... is your name?!", firstAttempts);
		Question questionTwo = new Question(2, "What... is your quest?!", secondAttempts);
		Question questionEasy = new Question(3,
				"What... is your favorite color?!", easyAttempts);
		Question questionHard = new Question(3,
				"What... is the average air-speed velocity of an unladen swallow!?",hardAttempts);
		
		Map<Integer,Question> bridgekeeperEasyQuestions = new HashMap<>();
		bridgekeeperEasyQuestions.put(questionOne.getQuestionId(), questionOne);
		bridgekeeperEasyQuestions.put(questionTwo.getQuestionId(), questionTwo);
		bridgekeeperEasyQuestions.put(questionEasy.getQuestionId(), questionEasy);
		
		Quiz bridgekeeperEasyQuiz = new Quiz("bridgekeeper_easy", bridgekeeperEasyQuestions);
		this.quizzes.put(bridgekeeperEasyQuiz.getName(), bridgekeeperEasyQuiz);
		
		Map<Integer,Question> bridgekeeperHardQuestions = new HashMap<>();
		bridgekeeperHardQuestions.put(questionOne.getQuestionId(), questionOne);
		bridgekeeperHardQuestions.put(questionTwo.getQuestionId(), questionTwo);
		bridgekeeperHardQuestions.put(questionEasy.getQuestionId(), questionHard);
		
		Quiz bridgekeeperHardQuiz = new Quiz("bridgekeeper_hard", bridgekeeperHardQuestions);
		this.quizzes.put(bridgekeeperHardQuiz.getName(), bridgekeeperHardQuiz);
	}

	public Map<String, Quiz> getQuizzes() {
		return quizzes;
	}
	
	public void setQuizzes(Map<String, Quiz> quizzes) {
		this.quizzes = quizzes;
	}
	
	public Quiz getQuiz(String quizName) throws QuizNotFoundException {
		return this.quizzes.get(quizName);
	}
	
	public Quiz addQuiz(Quiz quiz) {
		return this.quizzes.put(quiz.getName(), quiz);
	}
	
	public Quiz deleteQuiz(String quizName) throws QuizNotFoundException {
		return this.quizzes.remove(quizName);
	}
	
	public Quiz renameQuiz(String quizName, String newName) throws QuizNotFoundException, InvalidNameException {
		if (newName != null) {
			Quiz quiz = this.deleteQuiz(quizName);
			quiz.setName(newName);
			return this.addQuiz(quiz);
		}
		throw new InvalidNameException();
	}
	
	public Question randomQuizQuestion(String quizName) throws QuizNotFoundException {
		Quiz quiz = this.getQuiz(quizName);
		Object[] questionsArray = quiz.getQuestions().values().toArray();
		return (Question) questionsArray[new Random().nextInt(quiz.getQuestions().size())];
	}
	
	public Quiz addQuestionToQuiz(String quizName, Question question) throws QuizNotFoundException, InvalidQuestionException {
		if(question instanceof Question && question != null) {
			Quiz quiz = this.deleteQuiz(quizName);
			quiz.getQuestions().put(quiz.getQuestions().size()+1, question);
			this.addQuiz(quiz);
			return quiz;
		}
		throw new InvalidQuestionException();
	}
	
	public Question deleteQuestionFromQuiz(String quizName, String questionId) throws QuizNotFoundException, QuestionNotFoundException {
		if (questionId instanceof String && questionId != null) {
			Quiz quiz = this.deleteQuiz(quizName);
			quiz.getQuestions().remove(Integer.valueOf(questionId));
			this.addQuiz(quiz);
			return quiz.getQuestions().get(Integer.valueOf(questionId));
		}
		throw new QuestionNotFoundException();
	}
}
