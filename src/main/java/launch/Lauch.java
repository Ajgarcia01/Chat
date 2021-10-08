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
	}

}
