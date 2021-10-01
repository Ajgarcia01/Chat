module project.chat {
    requires javafx.controls;
    requires javafx.fxml;

    opens project.chat to javafx.fxml;
    exports project.chat;
}
