package project.chat.controller;

import project.chat.model.User;

public class UserDAO extends User{
	private static UserDAO _Instance;
	
	private UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	private UserDAO(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public static UserDAO getInstance() {
		if(_Instance==null) {
			_Instance=new UserDAO();
		}
		return _Instance;
	}
	public static UserDAO getInstance(String name) {
		if(_Instance==null) {
			_Instance=new UserDAO(name);
		}
		return _Instance;
	}
	
	
	
}
