package project.chat.model;

import java.util.Arrays;
import java.util.List;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="room")
public class Room {
	private String name;
	private List<Message> messages;
	private List<User>users;
	
	
	public Room() {
		
		super();
	}


	


	public Room(String name, List<Message> messages, List<User> users) {
		super();
		this.name = name;
		this.messages = messages;
		this.users = users;
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
	public String toString() {
		return "Room [name=" + name + ", messages=" + messages + ", users=" + users + "]";
	}





	
	
	
	
	
 
}
