package com.cooksys.ftd.springcontrollersandservicesKalkazar.exceptions;

public class InvalidQuestionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5843763030555329673L;
	
	private String message;
	
	public InvalidQuestionException() {
		this.message = "ERROR: this isn't the right format for a question";
	}
	
	public InvalidQuestionException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}