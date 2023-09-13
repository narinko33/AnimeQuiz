package model;

public class Ranking {
	private int id;
	private String name;
	private String good;
	private String updated;

	public Ranking() {
	}

	public Ranking(int id, String name, String good, String date) {
		this.id = id;
		this.name = name;
		this.good = good;
		this.updated = updated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGood() {
		return good;
	}

	public void setGood(String good) {
		this.good = good;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

}
