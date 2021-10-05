package project.chat.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="message")

public class Message {
	private User user;
	private LocalDateTime date;
	private String message;
	//¿Es necesario?
	private Room room;
	
	
	public Message() {
		this.user=new User();
		this.date=LocalDateTime.now();
		this.message="";
		this.room=new Room();
	}
	
	public Message(User user, String message, Room room) {
		super();
		this.user = user;
		this.date = LocalDateTime.now();
		this.message = message;
		this.room = room;
	}

	public Message(User user, LocalDateTime date, String message, Room room) {
		super();
		this.user = user;
		this.date = date;
		this.message = message;
		this.room = room;
	}


	public User getUser() {
		return user;
	}


	public LocalDateTime getDate() {
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
		return "Message [user=" + user + ", date=" + date + ", message=" + message + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result=false;
		if(obj!=null) {
			if(obj==this) {
				result=true;
			}
			else if(obj instanceof Message) {
				Message m=(Message)obj;
				if(m.getMessage()==this.message) {
					result=true;
				}
			}
		}
		return result;
	}
	
	
	

}
