package app.error;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ErrorController {

    @FXML
    private Label messageLabel;

    public void setMessage(String message) {
        this.messageLabel.setText(message);
    }
}
