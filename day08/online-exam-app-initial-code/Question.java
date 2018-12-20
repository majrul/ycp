package com.cdac.onlineexam;

import java.util.ArrayList;

public class Question {

	private String question;
	//private Option[] options;
	private ArrayList<Option> options;
	
	public Question() {
	}
	public Question(String question, ArrayList<Option> options) {
		this.question = question;
		this.options = options;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<Option> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}
}
