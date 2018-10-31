package com.cooksys.ftd.springcontrollersandservicesKalkazar.exceptions;

public class QuestionNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1024331438452002340L;
	
	private String message;
	
	public QuestionNotFoundException() {
		this.message = "ERROR: could not find the question in the collection";
	}
	
	public QuestionNotFoundException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}