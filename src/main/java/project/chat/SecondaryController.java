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
	
	
	
	@FXML
    private void setRoom() throws IOException, JAXBException, ClassNotFoundException {
	   UserRoom ur=UserRoom.get_Instance();
	   ur.setRooms(XMLManager.loadRooms("chat.xml"));
	   System.out.println(ur.getRooms().get(0));
	   Room  r1 = ur.getRooms().get(0);
	   System.out.println(r1);
	   
        	
        	if(sala1.isFocused()) {
        		 System.out.println("1");
        		 ur.addRoom(r1);
        		 System.out.println("añadida");
        		 XMLManager.marshal(ur, new File("chat.xml"));
        		 System.out.println(r1.getName());	
        		 modalChat();
        		
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
