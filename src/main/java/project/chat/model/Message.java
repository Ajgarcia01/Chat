package project.chat.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import project.chat.Utils.LocalDateTimeAdapter;


@XmlRootElement(name="hola")
@XmlAccessorType(XmlAccessType.NONE)
public class Message {
	
	Instant instant;
	@XmlElement(name="user")
	private User user;
	@XmlElement(name="content")
	private String message;
	@XmlAttribute(name="date")
	@XmlJavaTypeAdapter(value=LocalDateTimeAdapter.class)
	private LocalDateTime date;
	//¿Es necesario?
	//private Room room;
	
	
	public Message() {
		this.user=new User();
		this.message="";
		this.date=LocalDateTime.now();
	}
	
	public Message(User user, String message) {
		super();
		this.user = user;
		this.message = message;
		this.date=LocalDateTime.now();
	}
	
	

	public Message(User user, Date d, String message) {
		super();
		this.user = user;
		this.message = message;
		this.date=LocalDateTime.now();
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
	
	public void setUser(User user) {
		this.user = user;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Message [user=" + user + ", date=" + date.getHour() + ", message=" + message + "]";
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
				if(m.getDate().equals(this.date)&&m.getUser().equals(this.user)&&m.getMessage()==this.message) {
					result=true;
				}
			}
		}
		return result;
	}
}