package project.chat;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import project.chat.Utils.XMLManager;
import project.chat.controller.RoomDAO;
import project.chat.controller.UserDAO;
import project.chat.model.Room;
import project.chat.model.UserRoom;

public class SecondaryController {

	@FXML
	private Button out;
	@FXML
	private Button sala1;
	
	@FXML
	private Button sala2;
	
	@FXML
	private Button sala3;
	@FXML
	private Button sala4;
	
	
	UserRoom ur;
	UserDAO udao;
	Room rr;
	RoomDAO r2;
	
	@FXML
	private void  initialize() throws ClassNotFoundException {
		ur=UserRoom.get_Instance();
		udao=UserDAO.getInstance();
	}
	
	
	
	@FXML
    private void setRoom() throws IOException, JAXBException, ClassNotFoundException {	
		if(sala1.isFocused()) {
        		String sala=sala1.getText(); 
        		salas(sala);
        	}
		if(sala2.isFocused()) {
    		String sala=sala2.getText(); 
    		salas(sala);
    	}
		if(sala3.isFocused()) {
    		String sala=sala3.getText(); 
    		salas(sala);
    	}
		if(sala4.isFocused()) {
    		String sala=sala4.getText(); 
    		salas(sala);
    	}
        }
	
	@FXML
    public void modalChat() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("pantallaChat.fxml"));
		Parent modal;
		try {
			modal = fxmlLoader.load();
			Stage modalStage = new Stage();
			//modalStage.initModality(Modality.APPLICATION_MODAL);
			modalStage.initOwner(App.rootstage);
			modalStage.setResizable(false);
			Scene modalScene = new Scene(modal);
			modalStage.setScene(modalScene);
			modalStage.showAndWait();
			modalStage.setResizable(false);

		} catch (IOException ex) {
		}
        
    }
	
	@FXML
	private void exit(ActionEvent event) throws IOException {
	    Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	private void salas(String sala) throws IOException {
		rr=ur.searchRoom(sala);
		RoomDAO.getInstance(sala);
		if(rr.getName().equals("")) {
			rr.setName(sala);
			
		}
		
		try {
			XMLManager.marshal(ur, new File("chat.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modalChat();
	
	}
 }
