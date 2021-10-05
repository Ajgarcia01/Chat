package project.chat;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import project.chat.model.Room;

public class SecondaryController {

	@FXML
	private Button sala1;
	
	@FXML
	private Button sala2;
	
	@FXML
	private Button sala3;
	@FXML
	private Button sala4;
	
	
	
	@FXML
    private void setRoom() throws IOException {
        App.setRoot("pantallaChat");
        int nsala=0;
       Room r1 =new Room("Sala 1");
       Room r2 =new Room("Sala 2");
       Room r3 =new Room("Sala 3");
       Room r4 =new Room("Sala 4");
    
        	
        	if(sala1.isFocused()) {
        	System.out.println(r1.getName());
        		
        	}
        	if(sala2.isFocused()) {
        	System.out.println(r2.getName());	
        	}
        	if(sala3.isFocused()) {
            	System.out.println(r3.getName());	
            	}	
        	if(sala4.isFocused()) {
            	System.out.println(r4.getName());	
            	}	
        }
 }
