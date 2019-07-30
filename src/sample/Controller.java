package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    private String woodType;
    private String stringLength;
    private String stringDiameter;
    private double totalWeight = 0;

    @FXML
    private Button btnDodaj;

    @FXML
    private Button btnZeruj;

    @FXML
    private Label m3Label;

    @FXML
    private Label lacznieM3Label;

    @FXML
    private TextField lengthField;

    @FXML
    private TextField diameterField;

    @FXML
    private CheckBox checkBoxPicea;

    @FXML
    private CheckBox checkBoxPinus;

    @FXML
    private CheckBox checkBoxLarix;

    @FXML
    private CheckBox checkBoxFagus;

    @FXML
    private CheckBox checkBoxQuercus;


    public Controller() {

    }

    @FXML
    public String lengthActionField() {
        return lengthField.getText();
    }

    @FXML
    public String diameterActionField() {
        return diameterField.getText();
    }

    @FXML
    void initialize() {

        checkBoxPicea.setSelected(true);

        btnDodaj.setOnAction(event -> {
            stringLength = lengthActionField();
            stringDiameter = diameterActionField();

            int length = Integer.parseInt(stringLength);
            int diameter = Integer.parseInt(stringDiameter);

            actionDodaj();

            if (checkBoxPicea.isSelected()) {
                woodType = "Picea";

            } else if (checkBoxPinus.isSelected()) {
                woodType = "Pinus";

            } else if (checkBoxLarix.isSelected()) {
                woodType = "Larix";

            } else if (checkBoxFagus.isSelected()) {
                woodType = "Fagus";

            } else if (checkBoxQuercus.isSelected()) {
                woodType = "Quercus";
            }

            double v = Calculator.returnWoodWeightFX(length, diameter, woodType);
            totalWeight += v;

            String stringWoodWeight = Double.toString(v);
            String stringTotalWeight = Double.toString(totalWeight);

            m3Label.setText(stringWoodWeight);
            lacznieM3Label.setText(stringTotalWeight);

            lengthField.clear();
            diameterField.clear();
        });

        btnZeruj.setOnAction(event -> {
            m3Label.setText("0.00");
            lacznieM3Label.setText("0.00");
            totalWeight = 0;
        });
    }


    @FXML
    public void actionDodaj() {
        lengthActionField();
    }

    @FXML
    public void actionZeruj() {

    }

}
