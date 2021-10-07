package launch;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

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
		User u1=new User("Marronero69");
		RoomDAO r1=new RoomDAO("Sala1");
		RoomDAO r2=new RoomDAO("Sala2");
		Message m=new Message(u,"me cago en tus muelas",r1);
		Message m2=new Message(u2,"me cago ",r2);
		Message m3=new Message(u1,"Hola buenos dias a todos",r2);
		
		
		r2.addUser(u2);
		r2.addUser(u1);
		r2.addMessages(m2);
		r2.addMessages(m3);
		r1.addUser(u);
		r1.addMessages(m);
		//System.out.println(r1);
		
		UserRoom ur=new UserRoom();
		ur.addRoom(r1);
		ur.addRoom(r2);
		ur.addUser(u2);
		ur.addUser(u);
		ur.addUser(u1);
		
		
		
		File f = new File("chat.xml");
		try {
			XMLManager.unmarshal(f);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			XMLManager.marshal(ur, new File("chat.xml"));
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
