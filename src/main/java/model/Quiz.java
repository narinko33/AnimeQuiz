package model;

public class Quiz {
	private int id;
	private String text;
	private String answer;

	public Quiz() {
	}

	public Quiz(String text, String answer) {
		this.text = text;
		this.answer = answer;

	}

	public Quiz(int id, String text, String answer) {
		this(text, answer);
		this.id = id;

	}

	public int getId() {
		return id;
	}



	public String getText() {
		return text;
	}



	public String getAnswer() {
		return answer;
	}



}
