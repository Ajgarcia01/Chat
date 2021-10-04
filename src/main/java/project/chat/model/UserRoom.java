package project.chat.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="UserRoom")

public class UserRoom {
	@XmlElement(name="room",type=Room.class)
	
	private List<User> users;
	private List<Room> rooms;
	private static UserRoom singletoon;
	
	private UserRoom() {
		users=new ArrayList<>();
		rooms=new ArrayList<>();
	}
	
	//singleton
	public static UserRoom get_Instance() {
		singletoon=new UserRoom();
		
		return singletoon;
		
	}

}
