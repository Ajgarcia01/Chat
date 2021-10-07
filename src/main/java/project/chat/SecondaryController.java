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
	
	
	UserRoom ur=new UserRoom();
	@FXML
    private void setRoom() throws IOException, JAXBException {
       RoomDAO r1 =new RoomDAO("Sala 1");
       RoomDAO  r2 =new  RoomDAO ("Sala 2");
       RoomDAO  r3 =new  RoomDAO ("Sala 3");
       RoomDAO  r4 =new  RoomDAO ("Sala 4");
    
        	
        	if(sala1.isFocused()) {
        		modalChat();
        		ur.addRoom(r1);
        		XMLManager.marshal(ur, new File("chat.xml"));
        	System.out.println(r1.getName());
        		
        	}
        	if(sala2.isFocused()) {
        		modalChat();
        		ur.addRoom(r2);
        		XMLManager.marshal(ur, new File("chat.xml"));
        	System.out.println(r2.getName());	
        	}
        	if(sala3.isFocused()) {
        		modalChat();
        		ur.addRoom(r3);
        		XMLManager.marshal(ur, new File("chat.xml"));
            	System.out.println(r3.getName());	
            	}	
        	if(sala4.isFocused()) {
        		modalChat();
        		ur.addRoom(r4);
        		XMLManager.marshal(ur, new File("chat.xml"));
            	System.out.println(r4.getName());	
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
 }
