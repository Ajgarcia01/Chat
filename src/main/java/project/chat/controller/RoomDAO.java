package project.chat.controller;

import java.util.List;

import project.chat.model.Message;
import project.chat.model.Room;
import project.chat.model.User;

public class RoomDAO {
	private static String _Instance;
	
	
	
	private RoomDAO(String room) {
		_Instance=room;		
	}


	public static String getInstance() {
		if(_Instance==null) {
			_Instance="";
		}
		return _Instance;
	}
	public static String getInstance(String room) {
		if(_Instance==null) {
			_Instance=room;
		}else if(!_Instance.equals(room)) {
			_Instance=room;
		}
		return _Instance;
	}
	
	
	
	
}
