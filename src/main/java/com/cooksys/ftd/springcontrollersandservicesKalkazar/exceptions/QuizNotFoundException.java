package com.cooksys.ftd.springcontrollersandservicesKalkazar.exceptions;

public class QuizNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3959387979142308498L;
	
	private String message;
	
	public QuizNotFoundException() {
		this.message = "ERROR: quiz not found";
	}
	
	public QuizNotFoundException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}