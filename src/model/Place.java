package model;

public class Place {
	
	private static int curid = 0;
	private int id;
	private String name;
	
	public Place(String name) {
		this.id=++curid;
		this.name=name;
	}
	public Place(int id,String name) {
		this.id=id;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return this.name;
	}

}
