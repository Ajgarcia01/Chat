package project.chat.controller;

import project.chat.model.Room;
import project.chat.model.User;
import project.chat.model.UserRoom;

public class UserRoomDAO extends UserRoom{
	
	public boolean addUser(User user) {
		boolean result=false;
			if(user!=null&&!user.getName().equals("")) {
				if(!super.users.contains(user)) {
					super.users.add(user);
					result=true;
				}
			}
		return result;
	}
	public boolean addRoom(Room room) {
		boolean result=false;
			if(room!=null&&!room.getName().equals("")) {
				if(!super.rooms.contains(room)) {
					super.rooms.add(room);
					result=true;
				}
			}
		return result;
	}

}
