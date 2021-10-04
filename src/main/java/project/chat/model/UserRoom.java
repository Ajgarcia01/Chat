package project.chat.model;

import java.util.ArrayList;
import java.util.List;

public class UserRoom {
	
	private List<User> users;
	private List<Room> rooms;
	private static UserRoom singletoon;
	
	private UserRoom() {
		users=new ArrayList<>();
		rooms=new ArrayList<>();
	}
	public static UserRoom get_Instance() {
		singletoon=new UserRoom();
		
		return singletoon;
		
	}

}
