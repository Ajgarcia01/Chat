package project.chat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private Button send;
	
	
	@FXML
	private TextField write;
	
	@FXML
	private TextField salaes;
	
	@FXML
	private TextField chat;

	
	@FXML
	private TextField chat1;
	
	@FXML
	private Label settings;
	
	@FXML
	private Label chattext;

	@FXML
	private TableView<User> tablauser;
	@FXML
	private TableView<Message> tablamensages;
	@FXML
	private TableColumn<User, String> usuarios;
	
	@FXML
	private TableColumn<Message, String> messagecolumn;
	@FXML
	private TableColumn<Message, String> usercolumn;
	@FXML
	private TableColumn<Message, String> datecolumn;
	
	
	UserRoom ur;
	UserDAO udao;
	Room rr;
	String sala;
	
	
	
	@FXML
	private void  initialize() throws ClassNotFoundException {
		ur=UserRoom.get_Instance();
		udao=UserDAO.getInstance();
		sala=RoomDAO.getInstance();
		if(ur.searchRoom(sala).getName().equals("")){
			rr=new Room(sala);
		}else {
			rr=ur.searchRoom(sala);
		}
		rr.addUser(udao);
		salaes.setText(sala);
		chat1.setText(rr.getUsers().toString());

		tableUsuarios();
	}
	
	@FXML
	private void exit(ActionEvent event) throws IOException {
	    Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void writeMessage() throws IOException, JAXBException {
		rr.getName().concat(sala);
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
	
	@FXML
	public void tableUsuarios() {
		tablauser.setItems(FXCollections.observableArrayList(rr.getUsers()));
		usuarios.setCellValueFactory(new PropertyValueFactory<User, String>("usuarios"));
	}
	
	@FXML
	public void configureUsers() {
		
		 usuarios.setCellValueFactory(eachStudent -> {
	            SimpleStringProperty v = new SimpleStringProperty();
	            v.setValue(eachStudent.getValue().getName());
	            return v;
	        });
		}
}
