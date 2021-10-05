package launch;

import project.chat.controller.RoomDAO;
import project.chat.model.Message;
import project.chat.model.User;

public class Lauch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hola");

		
		User u=new User("antio");
		System.out.println(u.toString());
		
		
		User u2=new User("Pepito");
		User u3=new User("Atahualpa");
		User u4=new User("Chinco");
		RoomDAO r=new RoomDAO("Sala1");
		Message m=new Message(u,"me cago en tus muelas",r);
		Message m2=new Message(u2,"me cago ",r);
		Message m3=new Message(u3," tus muelas",r);
		Message m4=new Message(u4,"cago en tus muelas",r);
		r.addUser(u);
		r.addUser(u2);
		r.addUser(u3);
		r.addUser(u4);
		r.addMessages(m);
		r.addMessages(m2);
		System.out.println(r);
		
		System.out.println("hola");

	}

}
