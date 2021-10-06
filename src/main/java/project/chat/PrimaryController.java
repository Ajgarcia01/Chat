package project.chat;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
	
	
	 protected static Parent loadFXML(String fxml) throws IOException {
	        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
	        return fxmlLoader.load();
	    }
	
	@FXML
    private void setName() throws IOException {
			String usuario= nickname.getText();
			System.out.println(usuario);

    }
	
	}
