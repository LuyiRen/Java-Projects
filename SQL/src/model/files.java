package lab.model;

public class files {
	Integer id;
	String name;
	boolean is_folder;
	Integer parent_id;
	Integer owner_id;
	
	public files(Integer id, String name, boolean is_folder, Integer parent_id, Integer owner_id) {
		this.id = id;
		this.name = name;
		this.is_folder = is_folder;
		this.parent_id = parent_id;
		this.owner_id = owner_id;
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
	public boolean isIs_folder() {
		return is_folder;
	}
	public void setIs_folder(boolean is_folder) {
		this.is_folder = is_folder;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}

}
