package app.stackcalculator;

import java.io.IOException;
import java.util.List;

import app.MainContainerController;
import app.error.ErrorService;
import app.subtitles.EnglishSubtitles;
import app.subtitles.PolishSubtitles;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

import java.util.ArrayList;

public class StackCalculatorController {

    private ErrorService errorService = new ErrorService();
    private MainContainerController mainContainerController;
    private List<Double> heightsList = new ArrayList<>();
    private boolean isEnglishSubtitles;
    private int counter;

    @FXML
    private Label assortment;

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

    @FXML
    private ToggleButton toggleEng;

    @FXML
    private ToggleButton togglePl;


    public void setMainContainerController(MainContainerController mainContainerController) {
        this.mainContainerController = mainContainerController;
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
        final String stringAssortment = assortmentField.getText();
        final String stringWidth = widthField.getText();
        final String stringConverter = conv.getText();
        double volume = 0;

        try {

            final double assortment = Double.valueOf(stringAssortment);
            final double width = Double.valueOf(stringWidth);
            final double converter = Double.valueOf(stringConverter);

            volume = StackCalculatorService.returnStackWeight(assortment, width, converter, heightsList);

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

    @FXML
    public void actionToggleEng() {
        toggleEng.isSelected();
    }

    @FXML
    public void actionTogglePl() {
        togglePl.isSelected();
    }
}
