package lab.model;

public class users {
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
	public users(int id, String name) {
		this.id = id;
		this.name = name;
	}
	int id;
	String name;
}
