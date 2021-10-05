package project.chat.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="messages")

public class Message {
	
	private User user;
	private String message;
	
	private static LocalDateTime date;
	;
	//¿Es necesario?
	//private Room room;
	
	
	public Message() {
		this.user=new User();
		this.message="";
		this.date=LocalDateTime.now();
		
	}
	
	public Message(User user, String message, Room room) {
		super();
		this.user = user;
		this.date = LocalDateTime.now();
		this.message = message;
		
	}

	public Message(User user, LocalDateTime date, String message, Room room) {
		super();
		this.user = user;
		this.date = LocalDateTime.now();
		this.message = message;
	
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
