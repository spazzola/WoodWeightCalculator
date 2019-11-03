package app.error;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ErrorService {

    public void showError(String message) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("error.fxml"));
        Parent root = fxmlLoader.load();

        ErrorController errorWindow = fxmlLoader.getController();
        errorWindow.setMessage(message);

        Stage stage = new Stage();
        stage.setTitle("Error");
        stage.setScene(new Scene(root));

        stage.show();
    }

}
