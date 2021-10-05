module project.chat {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires java.xml.bind;
<<<<<<< HEAD
	requires javafx.graphics;
=======

>>>>>>> 8e06a2df3766506f37a9acc2b60363380220d985

    opens project.chat to javafx.fxml,javafx.base;
    exports project.chat;
   
    
}
