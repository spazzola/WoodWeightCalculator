package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.service.WoodCalculator;

public class Controller {

    private double lastWood;
    private double totalWeight = 0;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnReset;

    @FXML
    private Label m3;

    @FXML
    private Label sumM3;

    @FXML
    private Label sumM3Label;

    @FXML
    private Label lengthLabel;

    @FXML
    private Label diameterLabel;

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

    @FXML
    private ToggleButton toggleEng;

    @FXML
    private ToggleButton togglePl;

    @FXML
    void initialize() {

        toggleEng.setOnAction(event -> {
            setEnglishSubtitles();
        });

        togglePl.setOnAction(event -> {
            setPolishSubtitles();
        });

        checkBoxPicea.setSelected(true);
    }

    //TODO sprawdzic czy w fx da sie te checkboxy wrzucic do jednego kontenera tak ze mozna zaznaczyc tylko jeden
    //i wtedy pobrac ktory jest zaznaczony w jedniej linii
    private String getWoodType() {
        if (checkBoxPicea.isSelected()) {
            return "Picea";

        } else if (checkBoxPinus.isSelected()) {
            return "Pinus";

        } else if (checkBoxLarix.isSelected()) {
            return "Larix";

        } else if (checkBoxFagus.isSelected()) {
            return "Fagus";

        } else if (checkBoxQuercus.isSelected()) {
            return "Quercus";
        }

        return null;
    }

    @FXML
    public void actionDodaj() {
        final String stringLength = lengthField.getText();
        final String stringDiameter = diameterField.getText();

        final int length = Integer.parseInt(stringLength);
        final int diameter = Integer.parseInt(stringDiameter);

        final String woodType = getWoodType();
        double volume = 0;

        try {
            volume = WoodCalculator.returnWoodWeight(length, diameter, woodType);
            totalWeight += volume;
            lastWood = volume;
        } catch (NumberFormatException e) {
            //TODO zamienic souty na fx
            System.out.println("Incorrect type.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Value below 0, please insert positive value.");
        }


        final String stringWoodWeight = Double.toString(volume);
        final String stringTotalWeight = Double.toString(totalWeight);

        m3.setText(stringWoodWeight);
        sumM3.setText(stringTotalWeight);

        lengthField.clear();
        diameterField.clear();
    }

    @FXML
    public void actionZeruj() {
        btnReset.setOnAction(event -> {
            m3.setText("0.00");
            sumM3.setText("0.00");
            totalWeight = 0;
        });
    }

    @FXML
    public void actionUndo() {
        btnUndo.setOnAction(event -> {
            totalWeight -= lastWood;
            String stringTotalWeight = Double.toString(totalWeight);
            m3.setText("0.00");
            sumM3.setText(stringTotalWeight);
        });
    }

    @FXML
    public void actionToggleEng() {
        toggleEng.isSelected();
    }

    @FXML
    public void actionTogglePl() {
        togglePl.isSelected();
    }

    private void setPolishSubtitles() {
        btnAdd.setText(PolishSubtitles.BTN_ADD.getName());
        btnUndo.setText(PolishSubtitles.BTN_UNDO.getName());
        btnReset.setText(PolishSubtitles.BTN_RESET.getName());

        lengthLabel.setText(PolishSubtitles.LENGTH.getName());
        diameterLabel.setText(PolishSubtitles.DIAMETER.getName());
        sumM3Label.setText(PolishSubtitles.SUM_OF_M3.getName());

        checkBoxPicea.setText(PolishSubtitles.PICEA.getName());
        checkBoxPinus.setText(PolishSubtitles.PINUS.getName());
        checkBoxLarix.setText(PolishSubtitles.LARIX.getName());
        checkBoxFagus.setText(PolishSubtitles.FAGUS.getName());
        checkBoxQuercus.setText(PolishSubtitles.QUERCUS.getName());
    }

    private void setEnglishSubtitles() {
        btnAdd.setText(EnglishSubtitles.BTN_ADD.getName());
        btnUndo.setText(EnglishSubtitles.BTN_UNDO.getName());
        btnReset.setText(EnglishSubtitles.BTN_RESET.getName());

        lengthLabel.setText(EnglishSubtitles.LENGTH.getName());
        diameterLabel.setText(EnglishSubtitles.DIAMETER.getName());
        sumM3Label.setText(EnglishSubtitles.SUM_OF_M3.getName());

        checkBoxPicea.setText(EnglishSubtitles.PICEA.getName());
        checkBoxPinus.setText(EnglishSubtitles.PINUS.getName());
        checkBoxLarix.setText(EnglishSubtitles.LARIX.getName());
        checkBoxFagus.setText(EnglishSubtitles.FAGUS.getName());
        checkBoxQuercus.setText(EnglishSubtitles.QUERCUS.getName());
    }

}
