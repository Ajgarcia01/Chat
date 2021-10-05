package project.chat.model;

import java.time.Instant;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="hola")
@XmlAccessorType(XmlAccessType.NONE)
public class Message {
	
	Instant instant;
	@XmlElement(name="user")
	private User user;
	@XmlElement(name="message")
	private String message;
	@XmlAttribute(name="date")
	private static Date d = new Date();
	//¿Es necesario?
	//private Room room;
	
	
	public Message() {
		this.user=new User();
		this.message="";
		this.d=new Date();
		
	}
	
	public Message(User user, String message, Room room) {
		super();
		this.user = user;
		this.message = message;
		
	}

	public Message(User user, Date d, String message, Room room) {
		super();
		this.user = user;
		this.d=new Date();
		this.message = message;
	
	}


	public User getUser() {
		return user;
	}


	public Date getDate() {
		return d;
	}


	public String getMessage() {
		return message;
	}


	
	@Override
	public String toString() {
		return "Message [user=" + user + ", date=" + d + ", message=" + message + "]";
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
