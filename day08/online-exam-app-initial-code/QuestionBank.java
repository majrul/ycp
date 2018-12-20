package com.cdac.onlineexam;

import java.util.ArrayList;
import java.util.HashMap;

public class QuestionBank {

	private HashMap<String, ArrayList<Question>> questionBank;
	//private ArrayList<Question> questionsOnJava;

	//private ArrayList<Question> questionsOnDotNet;

	//private ArrayList<Question> questionsOnJavaScript;

	public QuestionBank() {
		questionBank = new HashMap<>();
	}
	
	public void addSubject(String subject) {
		questionBank.put(subject, new ArrayList<>());
	}
	
	public void addQuestion(String subject, Question question) {
		ArrayList<Question> questions = questionBank.get(subject);
		questions.add(question);
	}
	
	public ArrayList<Question> getQuestionsFor(String subject) {
		return questionBank.get(subject);
	}
	
	
}
