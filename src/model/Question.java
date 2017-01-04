package model;

public class Question {

	private int id;
	
	public enum QuestionType {
		EI, FT, JP, NS, ALL
	};
	
	private QuestionType questionType;
	private String text;
	
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
}
