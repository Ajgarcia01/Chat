package project.chat.model;

import java.util.ArrayList;
import java.util.List;

public class UserRoom {
<<<<<<< HEAD
	
	
=======
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

>>>>>>> 4739e7e12770d9af413f743108a3f9e0631c5da1
}
