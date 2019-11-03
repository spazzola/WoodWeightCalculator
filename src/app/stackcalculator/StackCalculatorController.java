package app.stackcalculator;

import app.MainContainerController;
import app.error.ErrorService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StackCalculatorController {

    private ErrorService errorService = new ErrorService();

    private MainContainerController mainContainerController;

    @FXML
    private Label typeLabel;

    @FXML
    private Label widthLabel;

    @FXML
    private Label heightLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label quantity;

    @FXML
    private Label sumLabel;

    @FXML
    private Label sum;

    @FXML
    private Button changeWindowButton;

    @FXML
    private Button addButton;

    @FXML
    private Button sumButton;

    @FXML
    private Button resetButton;



    public void setMainContainerController(MainContainerController mainContainerController) {
        this.mainContainerController = mainContainerController;
    }




}
