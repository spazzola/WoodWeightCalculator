package app;

import app.woodcalculator.WoodCalculatorController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainContainerController {

        @FXML
        private StackPane stackPane;

        @FXML
        public void initialize() {
            startApp();
        }


        public void startApp() {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("woodcalculator/woodcalculator.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            WoodCalculatorController woodCalculatorController = loader.getController();
            woodCalculatorController.setMainContainerController(this);

            setStackPane(pane);
        }

        public void setStackPane(Pane pane){
            stackPane.getChildren().clear();
            stackPane.getChildren().add(pane);
        }

}
