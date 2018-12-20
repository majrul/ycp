package com.cdac.onlineexam;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankLoader {

	QuestionBank questionBank = new QuestionBank();
	
	public List<Question> loadSampleQuestions(String subject) {
		questionBank.addSubject(subject);
		Question q = new Question();
		q.setQuestion("What is Java?");
		ArrayList<Option> options = new ArrayList<>();
		options.add(new Option("Java is a database", false));
		options.add(new Option("Java is a scripting language", false));
		options.add(new Option("Java is a programming language", true));
		options.add(new Option("Java is an OS", false));
		q.setOptions(options);
		questionBank.addQuestion(subject, q);
		
		q = new Question();
		q.setQuestion("What is a class?");
		options = new ArrayList<>();
		options.add(new Option("Class is a class", false));
		options.add(new Option("Class is a template for creating object", true));
		options.add(new Option("Class is another name for classroom", false));
		options.add(new Option("Class is an alien community", false));
		q.setOptions(options);
		questionBank.addQuestion(subject, q);

		q = new Question();
		q.setQuestion("What is G1?");
		options = new ArrayList<>();
		options.add(new Option("G1 is a Garbage Collector", true));
		options.add(new Option("G1 is SRK movie", false));
		options.add(new Option("G1 is Life", true));
		options.add(new Option("G1 is the name of spy agency", false));
		q.setOptions(options);
		questionBank.addQuestion(subject, q);
		
		return questionBank.getQuestionsFor(subject);
	}
		
}
