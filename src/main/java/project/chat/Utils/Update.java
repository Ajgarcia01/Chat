package project.chat.Utils;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.bind.JAXBException;

import javafx.application.Platform;
import project.chat.Utils.XMLManager;
import project.chat.model.UserRoom;

public class Update extends Thread {
	UserRoom r1;
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
	public void run() {
		
		Timer timer;
		timer = new Timer();

		TimerTask task = new TimerTask() {

		    @Override
		    public void run()
		    {
		    	try {
		    		System.out.println(XMLManager.unmarshalling("chat.xml"));
					
					System.out.println("HOLA");
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    };
		    // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
		timer.schedule(task, 10, 1000);
		}
}

