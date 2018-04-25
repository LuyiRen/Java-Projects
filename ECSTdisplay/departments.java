package lab15.model;

import java.util.ArrayList;
import java.util.List;

public class departments {
	public String name;
	public List<String> people;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPeople() {
		return people;
	}
	public void setPeople(List<String> people) {
		this.people = people;
	}
	public departments(String name) {
		this.name=name;
		people = new ArrayList<String>();
	}

}
