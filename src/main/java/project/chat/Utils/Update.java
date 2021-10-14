package project.chat.Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.bind.JAXBException;

import javafx.application.Platform;
import project.chat.Utils.XMLManager;
import project.chat.controller.RoomDAO;
import project.chat.controller.UserDAO;
import project.chat.model.Message;
import project.chat.model.Room;
import project.chat.model.User;
import project.chat.model.UserRoom;

public class Update extends Thread {
	UserRoom r1;
	Timer timer;
	
	public Update(){
		r1=UserRoom.get_Instance();
		timer = new Timer();
	}
	
	
	public void run() {
		r1=UserRoom.get_Instance();
		Timer timer = new Timer();
		timer = new Timer();

		TimerTask task = new TimerTask() {

		    @Override
		    public void run()
		    {
		    
		    	
		    	 
					
						try {
							XMLManager.marshal(r1,"chat.xml");
							XMLManager.unmarshalling("chat.xml");
						} catch (JAXBException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					
		    
		    		
			System.out.println("HOLA");
				
		    }
		    };
		    // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
		timer.schedule(task, 10, 1000);
		}
		
}

