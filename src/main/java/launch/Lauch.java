package launch;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBException;

import project.chat.Utils.XMLManager;
import project.chat.controller.RoomDAO;
import project.chat.model.Message;
import project.chat.model.Room;
import project.chat.model.User;
import project.chat.model.UserRoom;

public class Lauch {

	public static void main(String[] args) throws JAXBException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		LocalDateTimeAdapterTest();
		/*
		UserRoom ur=UserRoom.get_Instance();
		System.out.println("Hola");

		
		
		//System.out.println(u.toString());
		
		
		RoomDAO r1=new RoomDAO("Sala1");
		RoomDAO r2=new RoomDAO("Sala2");
		
		
		
		
		//System.out.println(r1);
		
		
		ur.addRoom(r1);
		ur.addRoom(r2);
		
		
		
		
		try {
			XMLManager.marshal(ur, new File("chat.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 	
		
		
		ur.setRooms(XMLManager.loadRooms("chat.xml"));
		System.out.println(ur);
		Room rr= ur.getRooms().get(0);
		System.out.println(rr);
		System.out.println(ur.getRooms().get(0));
		*/
	}
	public static void updateUserTest() {//funciona
		User u=new User("Juan");
		User u1=new User("Jose");
		User u2=new User("Juanitor");
		User u3=new User("Rambo");
		UserRoom ur=UserRoom.get_Instance();
		ur.addUser(u);
		ur.addUser(u1);
		ur.addUser(u2);
		ur.addUser(u3);
		System.out.println(ur.getUsers());
		ur.updateUser(u, "Juan23");
		System.out.println(ur.getUsers());
		
	}
	public static void updateRoomTest() {//funciona
		Room r=new Room("Algo");
		Room r1=new Room("Algo2");
		Room r2=new Room("Algo3");
		Room r3=new Room("Algo4");
		UserRoom ur=UserRoom.get_Instance();
		ur.addRoom(r);
		ur.addRoom(r1);
		ur.addRoom(r2);
		ur.addRoom(r3);
		System.out.println(ur.getRooms());
		ur.updateRoom(r,"asej" );
		System.out.println(ur.getRooms());
		System.out.println();
	}
	public static void LocalDateTimeAdapterTest() {
		UserRoom ur=UserRoom.get_Instance();
		Room r1=new Room("Sala1");
		Room r2=new Room("Sala2");
		User u=new User("Juan");
		User u1=new User("Jose");
		User u2=new User("Juanitor");
		User u3=new User("Rambo");
		Message m=new Message(u,"¿Queres algo?");
		Message m1=new Message(u1,"no");
		Message m2=new Message(u2,"yo si");
		r1.addUser(u);
		r1.addUser(u1);
		r1.addUser(u2);
		r1.addUser(u3);
		r2.addUser(u);
		r2.addUser(u2);
		r2.addUser(u3);
		r1.addMessages(m);
		r1.addMessages(m1);
		r1.addMessages(m2);
		r2.addMessages(m);
		r2.addMessages(m2);
		ur.addRoom(r1);
		ur.addRoom(r2);
		System.out.println(ur.toString());
		try {
			XMLManager.marshal(ur, new File("chat.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
