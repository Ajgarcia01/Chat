package project.chat.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="room")
public class Room {
	protected String name;
	protected List<Message> messages;
	protected List<User>users;
	
	
	public Room() {
		this.name="";
		this.messages = new ArrayList<>();
		this.users = new ArrayList<>();
	}

	public Room(String name, List<Message> messages, List<User> users) {
		super();
		this.name = name;
		this.messages = messages;
		this.users = users;
	}

	public Room(String name) {
		super();
		this.name = name;
		this.messages = new ArrayList<>();
		this.users = new ArrayList<>();
	}



	public String getName() {
		return name;
	}


	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result=false;
		if(obj!=null) {
			if(obj==this) {
				result=true;
			}
			else if(obj instanceof Room) {
				Room r=(Room)obj;
				if(r.getName()==this.name) {
					result=true;
				}
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Room [name=" + name + ", messages=" + messages + ", users=" + users + "]";
	}	
 
}