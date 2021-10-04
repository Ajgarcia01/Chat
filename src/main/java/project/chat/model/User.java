package project.chat.model;

public class User {
	private String name;
	
	public User() {
		super();
		this.name="";
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	

	
	
	

}
