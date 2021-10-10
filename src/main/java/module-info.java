module project.chat {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires java.xml.bind;
	requires javafx.graphics;

    opens project.chat to javafx.fxml,javafx.base;
    opens project.chat.model to  java.xml.bind;
    opens project.chat.Utils to com.sun.xml.bind.v2.ClassFactory;
    exports project.chat;
    exports project.chat.Utils;
   
    
}
