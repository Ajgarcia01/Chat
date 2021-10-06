package project.chat;

import java.io.IOException;

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
import project.chat.model.Room;

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
    private void setRoom() throws IOException {
       Room r1 =new Room("Sala 1");
       Room r2 =new Room("Sala 2");
       Room r3 =new Room("Sala 3");
       Room r4 =new Room("Sala 4");
    
        	
        	if(sala1.isFocused()) {
        		modalChat();
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
	
	@FXML
    public void modalChat() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("pantallaChat.fxml"));
		Parent modal;
		try {
			modal = fxmlLoader.load();
			Stage modalStage = new Stage();
			modalStage.initModality(Modality.APPLICATION_MODAL);
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
