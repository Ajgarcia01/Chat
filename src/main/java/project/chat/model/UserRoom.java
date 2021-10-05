package project.chat.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="UserRoom")

public class UserRoom {
	
	protected List<User> users;
	protected List<Room> rooms;
	private static UserRoom singletoon;
	
	protected UserRoom() {
		users=new ArrayList<>();
		rooms=new ArrayList<>();
	}
	public static UserRoom get_Instance() {
		singletoon=new UserRoom();
		
		return singletoon;
		
	}

}
