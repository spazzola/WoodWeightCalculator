package app.stackcalculator;

import java.io.IOException;
import java.util.List;

import app.MainContainerController;
import app.error.ErrorService;
import app.subtitles.EnglishSubtitles;
import app.subtitles.PolishSubtitles;
import app.woodcalculator.WoodCalculatorController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class StackCalculatorController {

    private ErrorService errorService = new ErrorService();
    private MainContainerController mainContainerController;
    private List<Double> heightsList = new ArrayList<>();
    private boolean isEnglishSubtitles;
    private double totalWeight = 0;
    private int counter;

    @FXML
    private Label assortmentLabel;

    @FXML
    private Label widthLabel;

    @FXML
    private Label heightMeasurementLabel;

    @FXML
    private Label converterLabel;

    @FXML
    private Label quantityLabel;

    @FXML
    private Label quantity;

    @FXML
    private Label m3Label;

    @FXML
    private Label m3;

    @FXML
    private Label sumM3Label;

    @FXML
    private Label sumM3;

    @FXML
    private Button switchWindowBtn;

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

    }

    @FXML
    public void actionAdd() throws IOException {
        String stringHeight = heightField.getText();

        try {
            heightsList.add(Double.valueOf(stringHeight));

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
        heightField.clear();

        counter++;
        quantity.setText(Integer.toString(counter));

    }

    @FXML
    public void actionSum() throws IOException {
        if (isConverterTyped()) {

            double volume = 0;

            try {
                //TODO move assortment, width to actionAdd and there handle exception
                final String stringAssortment = assortmentField.getText();
                final String stringWidth = widthField.getText();
                final String stringConverter = conv.getText();

                final double assortment = Double.valueOf(stringAssortment);
                final double width = Double.valueOf(stringWidth);
                final double converter = Double.valueOf(stringConverter);

                volume = StackCalculatorService.returnStackWeight(assortment, width, converter, heightsList);
                totalWeight += volume;

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

            final String stringVolume = Double.toString(volume);
            final String stringTotalWeight = Double.toString(totalWeight);

            m3.setText(stringVolume);
            sumM3.setText(stringTotalWeight);

            widthField.clear();
            assortmentField.clear();
            heightField.clear();
            heightsList.clear();
            quantity.setText("0");
            counter = 0;

        } else {
            if (isEnglishSubtitles) {
                this.errorService.showError(EnglishSubtitles.CONVERTER_NOT_TYPPED_ERROR.getName());

            } else {
                this.errorService.showError(PolishSubtitles.CONVERTER_NOT_TYPPED_ERROR.getName());
            }
        }

    }

    @FXML
    public void actionReset() {
        widthField.clear();
        assortmentField.clear();
        heightField.clear();
        heightsList.clear();
        m3.setText("0.0");
        sumM3.setText("0.0");
        quantity.setText("0");
        totalWeight = 0;
        counter = 0;
    }

    private boolean isConverterTyped() {
        return !conv.getText().isEmpty();
    }

    @FXML
    public void actionChangeWindow(){

    }

    @FXML
    public void openStackCalculator() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../woodcalculator/woodcalculator.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WoodCalculatorController woodCalculatorController = loader.getController();
        woodCalculatorController.setMainContainerController(mainContainerController);
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
        addButton.setText(PolishSubtitles.BTN_ADD.getName());
        resetButton.setText(PolishSubtitles.BTN_RESET.getName());
        sumButton.setText(PolishSubtitles.BTN_SUM.getName());
        switchWindowBtn.setText(PolishSubtitles.BTN_SWITCH_WINDOW_STCK.getName());

        assortmentLabel.setText(PolishSubtitles.ASSORTMENT.getName());
        widthLabel.setText(PolishSubtitles.WIDTH.getName());
        heightMeasurementLabel.setText(PolishSubtitles.HEIGHT_MEASUREMENT.getName());
        converterLabel.setText(PolishSubtitles.CONVERTER.getName());
        quantityLabel.setText(PolishSubtitles.QUANTITY.getName());
        m3Label.setText(PolishSubtitles.SUM.getName());
        sumM3Label.setText(PolishSubtitles.SUM_OF_M3.getName());

    }

    private void setEnglishSubtitles() {
        addButton.setText(EnglishSubtitles.BTN_ADD.getName());
        resetButton.setText(EnglishSubtitles.BTN_RESET.getName());
        sumButton.setText(EnglishSubtitles.BTN_SUM.getName());
        switchWindowBtn.setText(EnglishSubtitles.BTN_SWITCH_WINDOW_STCK.getName());

        assortmentLabel.setText(EnglishSubtitles.ASSORTMENT.getName());
        widthLabel.setText(EnglishSubtitles.WIDTH.getName());
        heightMeasurementLabel.setText(EnglishSubtitles.HEIGHT_MEASUREMENT.getName());
        converterLabel.setText(EnglishSubtitles.CONVERTER.getName());
        quantityLabel.setText(EnglishSubtitles.QUANTITY.getName());
        m3Label.setText(EnglishSubtitles.SUM.getName());
        sumM3Label.setText(EnglishSubtitles.SUM_OF_M3.getName());

        //TODO set same alignment as for Pl btn
        //switchWindowBtn.setAlignment(Pos.TOP_RIGHT);

        quantityLabel.setAlignment(Pos.TOP_RIGHT);
        sumM3Label.setAlignment(Pos.TOP_RIGHT);
    }

}
