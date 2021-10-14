package project.chat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import project.chat.Utils.Update;
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
	Update up1=new Update();
	@FXML
	private void  initialize() throws ClassNotFoundException, IOException, JAXBException {
		ur=UserRoom.get_Instance();
		udao=UserDAO.getInstance();
		sala=RoomDAO.getInstance();
		salaes.setText(sala);
		
		
		if(ur.searchRoom(sala).getName().equals("")){
			rr=new Room(sala);
			ur.addRoom(rr);
		}else {
			rr=ur.searchRoom(sala);
		}
		XMLManager.marshal(ur, new File("chat.xml"));
		rr.addUser(udao);
		tableUsuarios();
		tableMensajes();
		up1.run();
		
		//chat1.setText(ur.getUsers().toString());
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
		System.out.println(mg.toString());
		XMLManager.marshal(ur, new File("chat.xml"));
	   

	}
	
	
	
	
	@FXML
	public void tableUsuarios() {
		
	
		tablauser.setItems(FXCollections.observableArrayList(rr.getUsers()));
		usuarios.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
	}
	
	@FXML
	public void tableMensajes() {
		
		tablamensages.setItems(FXCollections.observableArrayList(rr.getMessages()));
		messagecolumn.setCellValueFactory(new PropertyValueFactory<Message,String>("message"));
		usercolumn.setCellValueFactory(new PropertyValueFactory<Message,String>("user"));
		datecolumn.setCellValueFactory(new PropertyValueFactory<Message,String>("date"));
	}
	
	

}
