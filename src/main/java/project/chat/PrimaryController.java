package project.chat;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project.chat.Utils.XMLManager;
import project.chat.controller.RoomDAO;
import project.chat.controller.UserDAO;
import project.chat.model.User;
import project.chat.model.UserRoom;

public class PrimaryController {
   
	@FXML
	private TextField nickname;
	
	@FXML
	private Button getin;
	UserRoom ur;
	UserDAO udao;
	
	@FXML
	private void initialize() throws ClassNotFoundException {
		ur=UserRoom.get_Instance();
		ur.setRooms(XMLManager.loadRooms("chat.xml"));
		ur.setUsers(XMLManager.loadUsers("chat.xml"));
		
	}
	

	
	 protected static Parent loadFXML(String fxml) throws IOException {
	        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
	        
	        
	        return fxmlLoader.load();
	    
	 }
	 @FXML
	    private void getin() throws IOException, JAXBException {
				setName();
			}
		 	
			

		
	@FXML
    private boolean setName() throws IOException, JAXBException {
			boolean result=false;	
			String name= nickname.getText();
			
			
			if(!ur.searchUser(name).getName().contains(name)) {
				udao=UserDAO.getInstance(name);
				ur.addUser(udao);
				XMLManager.marshal(ur, new File("chat.xml"));
				result=true;
				App.setRoot("pantallaChats");
				
			}else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("Este nombre ya existe, intente con otro");
				alert.showAndWait();
			}
			
			return result;
    }
	
	}
