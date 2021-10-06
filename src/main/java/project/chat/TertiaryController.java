package project.chat;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

public class TertiaryController {
	@FXML
	private Button out;
	
	
	@FXML
	private TextField writeMessage;
	
	@FXML
	private TextField messages;

	
	@FXML
	private void exit(ActionEvent event) throws IOException {
	    Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
	}
	
}
