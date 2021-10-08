package project.chat;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project.chat.Utils.XMLManager;
import project.chat.controller.RoomDAO;
import project.chat.model.User;
import project.chat.model.UserRoom;

public class PrimaryController {
   
	@FXML
	private TextField nickname;
	
	@FXML
	private Button getin;
	
	@FXML
	private void Initializable() throws ClassNotFoundException {
		UserRoom ur=UserRoom.get_Instance();
		ur.setRooms(XMLManager.loadRooms("chat.xml"));
	}
	
	@FXML
    private void getin() throws IOException, JAXBException {
		setName();
		App.setRoot("pantallaChats");
		
    }
	
	
	 protected static Parent loadFXML(String fxml) throws IOException {
	        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
	        
	        
	        return fxmlLoader.load();
	    
	 }
	
	@FXML
    private void setName() throws IOException, JAXBException {
			UserRoom ur=UserRoom.get_Instance();
			try {
				ur.setRooms(XMLManager.loadRooms("chat.xml"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String name= nickname.getText();
			RoomDAO rDAO= new RoomDAO();
			User u= new User();
			rDAO.addUser(u);
			u.setName(name);
			ur.addUser(u);
			u.setName(name);
			XMLManager.marshal(ur, new File("chat.xml"));
			System.out.println(name);

    }
	
	}
