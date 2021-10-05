package project.chat.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="UserRoom")

public class UserRoom {
	protected List<User> users;

	protected List<Room> rooms;
	private static UserRoom singletoon;
	
	public UserRoom() {
		users=new ArrayList<>();
		rooms=new ArrayList<>();
	}
	
	//singleton
	public static UserRoom get_Instance() {
		singletoon=new UserRoom();
		
		return singletoon;
		
	}
	
	public boolean addUser(User user) {
		boolean result=false;
			if(user!=null&&!user.getName().equals("")) {
				if(!this.users.contains(user)) {
					this.users.add(user);
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
	
	public boolean addRoom(Room room) {
		boolean result=false;
			if(room!=null&&!room.getName().equals("")) {
				if(!this.rooms.contains(room)) {
					this.rooms.add(room);
					result=true;
				}
			}
		return result;
	}
	public boolean removeRoom(Room room) {
		boolean result = false;
		if (room != null) {
			if (this.rooms.size() > 0 && this.users.contains(room)) {
				this.rooms.remove(room);
				result = true;
			}
		}
		return result;
	}
}
