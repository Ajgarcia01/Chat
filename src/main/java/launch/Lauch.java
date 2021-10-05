package launch;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import project.chat.Utils.XMLManager;
import project.chat.controller.RoomDAO;
import project.chat.model.Message;
import project.chat.model.User;
import project.chat.model.UserRoom;

public class Lauch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hola");

		
		
		//System.out.println(u.toString());
		
		User u=new User("Jeft11");
		User u2=new User("Manolo72");
		RoomDAO r=new RoomDAO("Sala1");
		Message m=new Message(u,"me cago en tus muelas",r);
		Message m1=new Message(u,"k haceh tio",r);
		Message m2=new Message(u2,"me cago ",r);
		r.addUser(u);
		r.addUser(u2);
		r.addMessages(m);
		r.addMessages(m1);
		r.addMessages(m2);
		System.out.println(r);
		UserRoom r1=new UserRoom();
		r1.addRoom(r);
		r1.addUser(u);
		r1.addUser(u2);
		try {
			XMLManager.marshal(r1, new File("chat.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hecho");

	}

}
