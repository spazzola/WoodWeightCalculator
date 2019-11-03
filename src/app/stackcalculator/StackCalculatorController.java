package app.stackcalculator;

import java.util.List;

import app.MainContainerController;
import app.error.ErrorService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class StackCalculatorController {

    private ErrorService errorService = new ErrorService();

    private MainContainerController mainContainerController;

    private List<Double> heightsList = new ArrayList<>();

    private int counter;

    @FXML
    private Label typeLabel;

    @FXML
    private Label widthLabel;

    @FXML
    private Label heightLabel;

    @FXML
    private Label converterLabel;

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

    @FXML
    private TextField assortmentField;

    @FXML
    private TextField widthField;

    @FXML
    private TextField heightField;

    @FXML
    private TextField conv;


    public void setMainContainerController(MainContainerController mainContainerController) {
        this.mainContainerController = mainContainerController;
    }


    @FXML
    public void actionAdd() {
        String stringHeight = heightField.getText();
        heightsList.add(Double.valueOf(stringHeight));

        heightField.clear();

        counter++;
        quantity.setText(Integer.toString(counter));

    }

    @FXML
    public void actionSum() {
        final String stringAssortment = assortmentField.getText();
        final String stringWidth = widthField.getText();
        final String stringConverter = conv.getText();

        final double assortment = Double.valueOf(stringAssortment);
        final double width = Double.valueOf(stringWidth);
        final double converter = Double.valueOf(stringConverter);

        final double volume = StackCalculatorService.returnStackWeight(assortment, width, converter, heightsList);

        final String stringVolume = Double.toString(volume);

        sum.setText(stringVolume);

        widthField.clear();
        assortmentField.clear();
        heightField.clear();
        heightsList.clear();
        quantity.setText("0");
    }

    @FXML
    public void actionReset() {
        widthField.clear();
        assortmentField.clear();
        heightField.clear();
        heightsList.clear();
        sum.setText("0.0");
        quantity.setText("0");
    }

}
