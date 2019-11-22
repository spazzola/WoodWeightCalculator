package app.woodcalculator;

import app.MainContainerController;
import app.error.ErrorService;
import app.stackcalculator.StackCalculatorController;
import app.subtitles.EnglishSubtitles;
import app.subtitles.PolishSubtitles;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class WoodCalculatorController {

    private ErrorService errorService = new ErrorService();
    private MainContainerController mainContainerController;
    private boolean isEnglishSubtitles;
    private double lastWood;
    private double totalWeight = 0;

    @FXML
    private Button switchWindowBtn;

    @FXML
    private Button addBtn;

    @FXML
    private Button undoBtn;

    @FXML
    private Button resetBtn;

    @FXML
    private Label sumM3Label;

    @FXML
    private Label lengthLabel;

    @FXML
    private Label diameterLabel;

    @FXML
    private Label m3;

    @FXML
    private Label sumM3;

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


    public void setMainContainerController(MainContainerController mainContainerController) {
        this.mainContainerController = mainContainerController;
    }

    @FXML
    void initialize() {

        toggleEng.setOnAction(event -> {
            setEnglishSubtitles();
            isEnglishSubtitles = true;
        });

        togglePl.setOnAction(event -> {
            setPolishSubtitles();
            isEnglishSubtitles = false;
        });

        checkBoxPicea.setSelected(true);
    }


    //TODO move checkboxex to one box, while one is selected, another can't be
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
    public void actionAdd() throws IOException {
        final String stringLength = lengthField.getText();
        final String stringDiameter = diameterField.getText();
        double volume = 0;

        try {

            final int length = Integer.parseInt(stringLength);
            final int diameter = Integer.parseInt(stringDiameter);

            if (length < 0 || diameter < 0) {
                throw new IllegalArgumentException();
            }

            final String woodType = getWoodType();

            volume = WoodCalculatorService.returnWoodWeight(length, diameter, woodType);
            totalWeight += volume;
            lastWood = volume;


        } catch (NumberFormatException e) {
            if (isEnglishSubtitles) {
                this.errorService.showError(EnglishSubtitles.INCORRECT_TYPE_ERROR.getName());

            } else {
                this.errorService.showError(PolishSubtitles.INCORRECT_TYPE_ERROR.getName());
            }

        } catch (IllegalArgumentException e) {
            if (isEnglishSubtitles) {
                this.errorService.showError(EnglishSubtitles.NEGATIVE_VALUE_ERROR.getName());

            } else {
                this.errorService.showError(PolishSubtitles.NEGATIVE_VALUE_ERROR.getName());
            }
        }


        final String stringWoodWeight = Double.toString(volume);
        final String stringTotalWeight = Double.toString(totalWeight);

        m3.setText(stringWoodWeight);
        sumM3.setText(stringTotalWeight);

        lengthField.clear();
        diameterField.clear();
    }

    @FXML
    public void actionReset() {
        resetBtn.setOnAction(event -> {
            m3.setText("0.00");
            sumM3.setText("0.00");
            totalWeight = 0;
        });
    }

    @FXML
    public void actionUndo() {
        undoBtn.setOnAction(event -> {
            totalWeight -= lastWood;
            String stringTotalWeight = Double.toString(totalWeight);
            m3.setText("0.00");
            sumM3.setText(stringTotalWeight);
        });
    }

    @FXML
    public void openStackCalculator() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../stackcalculator/stackcalculator.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StackCalculatorController stackCalculatorController = loader.getController();
        stackCalculatorController.setMainContainerController(mainContainerController);
        mainContainerController.setStackPane(pane);
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
        addBtn.setText(PolishSubtitles.BTN_ADD.getName());
        undoBtn.setText(PolishSubtitles.BTN_UNDO.getName());
        resetBtn.setText(PolishSubtitles.BTN_RESET.getName());
        switchWindowBtn.setText(PolishSubtitles.BTN_SWITCH_WINDOW_WD.getName());

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
        addBtn.setText(EnglishSubtitles.BTN_ADD.getName());
        undoBtn.setText(EnglishSubtitles.BTN_UNDO.getName());
        resetBtn.setText(EnglishSubtitles.BTN_RESET.getName());
        switchWindowBtn.setText(EnglishSubtitles.BTN_SWITCH_WINDOW_WD.getName());

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
