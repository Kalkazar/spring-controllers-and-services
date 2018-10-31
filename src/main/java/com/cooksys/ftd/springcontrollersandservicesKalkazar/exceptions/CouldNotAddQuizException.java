package com.cooksys.ftd.springcontrollersandservicesKalkazar.exceptions;

public class CouldNotAddQuizException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6485412657690465535L;
	
	private String message;
	
	public CouldNotAddQuizException() {
		this.message = "ERROR: was unable to add quiz";
	}
	
	public CouldNotAddQuizException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}