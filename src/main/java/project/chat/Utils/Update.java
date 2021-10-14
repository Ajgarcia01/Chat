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
import project.chat.model.User;
import project.chat.model.UserRoom;

public class Update extends Thread {
	UserRoom r1=UserRoom.get_Instance();
	
	/* 
	@Override
	public void run() {
	        refresqueshion();
	    }
	    public void refresqueshion() {
	    Timer t = new Timer();
	    t.schedule(new TimerTask() {
	        public void run() {
	            Platform.runLater(() -> {
	            	try {
						XMLManager.unmarshalling("chat.xml");
						System.out.println("HOLA");
					} catch (JAXBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            });
	        }
	    }, 0, 6000);
	    }
	  */  
	public void update() {
		
		Timer timer;
		timer = new Timer();

		TimerTask task = new TimerTask() {

		    @Override
		    public void run()
		    {
		    List<User> lista=r1.getUsers();
		    
		    r1.validation(lista, UserDAO.getInstance());
		    		
			System.out.println("HOLA");
				
		    }
		    };
		    // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
		timer.schedule(task, 10, 1000);
		}
}

