package project.chat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import project.chat.Utils.XMLManager;
import project.chat.controller.RoomDAO;
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

	
	
	
	@FXML
	private void exit(ActionEvent event) throws IOException {
	    Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void writeMessage() throws IOException, JAXBException {
		UserRoom ur=new UserRoom();
		RoomDAO RO=new RoomDAO();
		Room rm=new Room();
		String contenido=write.getText();
		chat.setText(contenido);
		writeUsers();
		XMLManager.marshal(ur, new File("chat.xml"));
	   
	}
	
	@FXML
	private void updateName() throws IOException {
		String u1 = this.old.getText();
		String u2 = this.newname.getText();
		/*
		if () {
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
		*/
	   
	}
	

	@FXML
	private void writeUsers() throws IOException, JAXBException {
		Room r1=new Room();
		System.out.println(r1.getUsers());
		List<User>users = r1.getUsers();
		chat1.setText(users.toString());
	   
	}
	
	
}
