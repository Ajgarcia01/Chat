module project.chat {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires java.xml.bind;
	requires org.junit.jupiter.api;

    opens project.chat to javafx.fxml,javafx.base, org.junit.jupiter.api ;
    exports project.chat;
    
}
