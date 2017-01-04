package model;

import java.io.Serializable;

public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	public enum QuestionType {
		EI, FT, JP, NS, ALL
	};
	
	private QuestionType questionType;
	private String text;
	private int userRate;
	
	public Question(int id, QuestionType questionType, String text) {
		super();
		this.id = id;
		this.questionType = questionType;
		this.text = text;
	}
	
	public Question(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUserRate() {
		return userRate;
	}

	public void setUserRate(int userRate) {
		this.userRate = userRate;
	}	
}
