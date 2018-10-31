package com.cooksys.ftd.springcontrollersandservicesKalkazar.service;

public class Answer {
	
	private Character answerId;
	private String answer;
	private boolean validity;
	
	public Answer() {}

	public Answer(Character answerId, String answer, boolean validity) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.validity = validity;
	}

	public Character getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Character answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean getValidity() {
		return validity;
	}

	public void setValidity(boolean validity) {
		this.validity = validity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((answerId == null) ? 0 : answerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (answerId == null) {
			if (other.answerId != null)
				return false;
		} else if (!answerId.equals(other.answerId))
			return false;
		return true;
	}
	
}