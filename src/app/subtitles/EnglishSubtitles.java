package app.subtitles;

public enum EnglishSubtitles {

/*
   WoodCalculatorController
*/
    LENGTH("Length"),
    DIAMETER("Diameter"),

    PICEA("Spruce"),
    PINUS("Pine"),
    LARIX("Larch"),
    FAGUS("Beech"),
    QUERCUS("Oak"),

    SUM_OF_M3("Sum of m3"),

    BTN_ADD("Add"),
    BTN_UNDO("Undo"),
    BTN_RESET("Reset"),

/*
   Error messages
*/
    NEGATIVE_VALUE_ERROR("Value below 0. Please enter positive number."),
    INCORRECT_TYPE_ERROR("Incorrect type. Please enter numbers."),

/*
   Stack CalculatorController
*/
    ASSORTMENT("Assortment"),
    WIDTH("Width"),
    HEIGHT_MEASUREMENT("Height measurement"),
    CONVERTER("Converter"),
    QUANTITY("Counter:"),
    SUM("Sum"),

    BTN_SUM("Add up");



    private String name;

    EnglishSubtitles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
