package project.chat;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

   
	@FXML
	private TextField nickname;
	
	@FXML
	private Button getin;
	
	
	@FXML
    private void getin() throws IOException {
		setName();
		App.setRoot("pantallaChats");

    }
	
	
	@FXML
    private void setName() throws IOException {
		
			String usuario= nickname.getText();
			System.out.println(usuario);

    }
	
	}
