package model;

public class Ranking {
	private int id;
	private String name;
	private int good;
	private String updated;

	public Ranking() {
	}

	public Ranking(String name, String updated) {
		this.name = name;
		this.updated = updated;
	}
	
	public Ranking(int id, String name, int good, String updated) {
		this(name,updated);
		this.id = id;
		this.good = good;
	}

	public void addGood() {
		this.good++;
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

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}


}
