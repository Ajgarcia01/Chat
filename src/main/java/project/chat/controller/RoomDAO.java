package project.chat.controller;

import java.util.List;

import project.chat.model.Message;
import project.chat.model.Room;
import project.chat.model.User;

public class RoomDAO extends Room{

	public RoomDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomDAO(String name, List<Message> messages, List<User> users) {
		super(name, messages, users);
		// TODO Auto-generated constructor stub
	}
	public RoomDAO(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public boolean addMessages(Message message) {
		boolean result=false;
			if(message!=null&&!message.equals("")) {
				if(super.users.contains(message.getUser())) {
					super.messages.add(message);
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
				if(!super.users.contains(user)) {
					super.users.add(user);
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
	
}
