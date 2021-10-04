package project.chat.model;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		boolean result=false;
		if(obj!=null) {
			if(obj==this) {
				result=true;
			}
			else if(obj instanceof User) {
				User u=(User)obj;
				if(u.getName()==this.name) {
					result=true;
				}
			}
		}
		return result;
	}
	
	

	
	
	

}
