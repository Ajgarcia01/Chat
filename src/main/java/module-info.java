module project.chat {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires java.xml.bind;
	requires javafx.graphics;

    opens project.chat to javafx.fxml,javafx.base;
    opens project.chat.model to  java.xml.bind;
    exports project.chat;
   
    
}
