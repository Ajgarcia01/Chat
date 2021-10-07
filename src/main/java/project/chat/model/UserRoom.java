package project.chat.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="CHAT")

public class UserRoom {
	@XmlElementWrapper(name="usersOnline")
	@XmlElement(name="user")
	protected List<User> users;
	@XmlElementWrapper(name="Rooms")
	@XmlElement(name="room")
	protected List<Room> rooms;
	private static UserRoom singletoon;
	
	protected UserRoom() {
		users=new ArrayList<>();
		rooms=new ArrayList<>();
	}
	
	//singleton
	public static UserRoom get_Instance() {
		singletoon=new UserRoom();
		
		return singletoon;
		
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
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
	
	public Room searchRoom(String name) {
		Room result=new Room();
		if(name!=null&&!name.equals("")) {
			for (int i = 0; i < rooms.size(); i++) {
				if (rooms.get(i).getName().equals(name)) {
					result = rooms.get(i);
					i = rooms.size();
				}
			}
		}
		return result;
	}
	public User searchUser(String name) {
		User result=new User();
		if(name!=null&&!name.equals("")) {
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getName().equals(name)) {
					result = users.get(i);
					i = users.size();
				}
			}
		}
		return result;
	}
	
	
	

	@Override
	public String toString() {
		return "UserRoom [users=" + users + ", rooms=" + rooms + "]";
	}
	
}
