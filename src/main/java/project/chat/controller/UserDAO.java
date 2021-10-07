package project.chat.controller;

import project.chat.model.User;

public class UserDAO extends User{
	private static UserDAO _Instance;

	public UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	private UserDAO(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public UserDAO getInstance() {
		if(_Instance==null) {
			_Instance=new UserDAO();
		}
		return _Instance;
	}
	public UserDAO getInstance(String name) {
		if(_Instance==null) {
			_Instance=new UserDAO(name);
		}
		return _Instance;
	}
	
	
	
}
