package com.cooksys.ftd.springcontrollersandservicesKalkazar.service;

import java.util.Map;

public class Quiz {
	
	private String name;
	private Map<Integer, Question> questions;
	
	public Quiz() {}

	public Quiz(String name, Map<Integer, Question> questions) {
		super();
		this.name = name;
		this.questions = questions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Map<Integer, Question> questions) {
		this.questions = questions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Quiz other = (Quiz) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equalsIgnoreCase(other.name))
			return false;
		return true;
	}
	
}
