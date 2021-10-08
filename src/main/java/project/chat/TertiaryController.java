package project.chat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import project.chat.Utils.XMLManager;
import project.chat.controller.RoomDAO;
import project.chat.controller.UserDAO;
import project.chat.model.Message;
import project.chat.model.Room;
import project.chat.model.User;
import project.chat.model.UserRoom;


public class TertiaryController {
	@FXML
	private Button exit;
	
	@FXML
	private Button update;
	
	@FXML
	private Button send;
	
	
	@FXML
	private TextField write;
	
	@FXML
	private TextField chat;
	

	@FXML
	private TextField old;
	

	@FXML
	private TextField newname;
	
	@FXML
	private TextField chat1;
	
	@FXML
	private Label settings;
	
	@FXML
	private Label chattext;

	UserRoom ur=UserRoom.get_Instance();
	UserDAO udao=UserDAO.getInstance();
	RoomDAO rr;
	
	@FXML
	private void exit(ActionEvent event) throws IOException {
	    Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void writeMessage() throws IOException, JAXBException {
		ur.getRooms().get(0);
		String mensaje=write.getText();
		System.out.println(mensaje);
		Message mg=new Message(udao, mensaje);
		rr.addMessages(mg);
		System.out.println(mg.getMessage());
		
		
		chat.setText(rr.getMessages().toString());
		XMLManager.marshal(ur, new File("chat.xml"));
	   

	}
	
	
	@FXML
    public void modalUpdate() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("nickname.fxml"));
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
	
	/*
	@FXML
	private void updateName() throws IOException {
		String u1 = this.old.getText();
		String u2 = this.newname.getText();
		RoomDAO ur=new RoomDAO();
		User u11=new User();
		u11.setName(u2);
		
		if (ur.addUser(u11)==true) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("ENHORABUENA");
			alert.setContentText("USUARIO MODIFICADO CON EXITO");
			alert.showAndWait();
			
		} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("EN ALGO TE HAS EQUIVOCADO");
				alert.showAndWait();
		
		}
		
	   
	}
	*/

	@FXML
	private void writeUsers() throws IOException, JAXBException {
		chat1.setText(ur.getUsers().toString());
	}
	
	
}
