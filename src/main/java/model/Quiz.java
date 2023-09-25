package model;

public class Quiz {
	private int id;
	private String text;
	private String select;
	private String answer;

	public Quiz() {
	}

	public Quiz(String text, String select, String answer) {
		this.text = text;
		this.select = select;
		this.answer = answer;

	}

	public Quiz(int id, String text, String select, String answer) {
		this(text, select, answer);
		this.id = id;

	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getSelect() {
		return select;
	}

	public String getAnswer() {
		return answer;
	}

}
