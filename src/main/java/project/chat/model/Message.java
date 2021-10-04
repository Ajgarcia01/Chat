package project.chat.model;

import java.util.Date;

public class Message {
	private User user;
	private Date date;
	private String message;
	private Room room;
	
	
	public Message() {
		super();
	}


	public Message(User user, Date date, String message, Room room) {
		super();
		this.user = user;
		this.date = date;
		this.message = message;
		this.room = room;
	}


	public User getUser() {
		return user;
	}


	public Date getDate() {
		return date;
	}


	public String getMessage() {
		return message;
	}


	public Room getRoom() {
		return room;
	}


	@Override
	public String toString() {
		return "Message [user=" + user + ", date=" + date + ", message=" + message + ", room=" + room + "]";
	}
	
	
	
	

}
