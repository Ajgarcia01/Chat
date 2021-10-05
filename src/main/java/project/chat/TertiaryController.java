package project.chat;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TertiaryController {
	@FXML
	private TextField exitbutton;
	
	
	@FXML
	private TextField writeMessage;
	
	@FXML
	private TextField messages;
	
	
	@FXML
	public void exit() throws IOException {
		App.setRoot("PantallaUser");
	}
	
}
