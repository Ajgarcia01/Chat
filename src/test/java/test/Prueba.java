package test;

import static org.junit.Assert.*;

import org.junit.Test;

import project.chat.controller.RoomDAO;
import project.chat.model.Message;
import project.chat.model.User;

public class Prueba {

	@Test
	public void test() {
		User u1=new User("Juan");
		User u2=new User("Antonio");
		User u3=new User("Pedro");
		RoomDAO r=new RoomDAO("Sala1");
		r.addUser(u1);
		r.addUser(u2);
		r.addUser(u3);
		Message m1=new Message(u1,"Hola",r);
		Message m2=new Message(u2,"¿Que haces?",r);
		Message m3=new Message(u3,"Algo",r);
		r.addMessages(m1);
		r.addMessages(m2);
		r.addMessages(m3);
		System.out.println(r.getMessages());
	}

}
