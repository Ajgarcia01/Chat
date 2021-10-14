package project.chat.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import project.chat.controller.UserDAO;

@XmlAccessorType(XmlAccessType.NONE)
public class Room {
	@XmlAttribute(name="name")
	protected String name;
	@XmlElementWrapper(name="messages")
	@XmlElement(name="message")
	protected List<Message> messages;
	@XmlElementWrapper(name="users")
	@XmlElement(name="usuario")
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
	public void setName(String name) {
		this.name = name;
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
	
	public boolean addMessages(Message message) {
		boolean result=false;
			if(message!=null&&!message.equals("")) {
				if(users.contains(message.getUser())) {
					messages.add(message);
					result=true;
				}
			}
		return result;
	}
	 public boolean removeMessage(Message message) {
	        boolean result = false;
	        if (message != null) {
	            if (this.messages.size() > 0 && this.messages.contains(message)) {
	                this.messages.remove(messages);
	                result = true;
	            }
	        }
	        return result;
	    }
	    
	    public boolean addUser(User user) {
	        boolean result=false;
	            if(user!=null&&!user.getName().equals("")) {
	                if(!users.contains(user)) {
	                    users.add(user);
	                    result=true;
	                }
	            }
	        return result;
	    }
	    public boolean removeUser(User user) {
	        boolean result = false;
	        if (user != null) {
	            if (this.users.size() > 0 && this.users.contains(user)) {
	                this.users.remove(user);
	                result = true;
	            }
	        }
	        return result;
	    }
	    
	    
	public List<Message> userMessage(UserDAO uDAO) {
		List<Message> result=new ArrayList<>();
			if(uDAO!=null) {
				for (Message message : messages) {
					if(message.getUser().equals(uDAO)) {
						result.add(message);
					}
				}
			}
		
		return result;
	}
	public void validationMessage(List<Message> xmlMessages,UserDAO uDAO) {
		List<Message> userMessages=userMessage(uDAO);
		if(xmlMessages!=null) {
			for (Message message : userMessages) {
				if(!xmlMessages.contains(message)) {
					xmlMessages.add(message);
				}
			}	
			messages=xmlMessages;
		}		
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
		return "Room [name=" + name + ", users=" +users+ ", messages=" + messages.toString() + "]";
	}

	//+ users.toString() 
 
}