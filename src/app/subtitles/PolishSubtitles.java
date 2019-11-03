package app.subtitles;

public enum PolishSubtitles {

/*
   WoodCalculatorController
*/
    LENGTH("Długość"),
    DIAMETER("Średnica"),

    PICEA("Świerk"),
    PINUS("Sosna"),
    LARIX("Modrzew"),
    FAGUS("Buk"),
    QUERCUS("Dąb"),

    SUM_OF_M3("Łącznie m3"),

    BTN_ADD("Dodaj"),
    BTN_UNDO("Cofnij"),
    BTN_RESET("Zeruj"),

/*
   Error messages
*/
    NEGATIVE_VALUE_ERROR("Wartość poniżej 0. Wprowadź dodatnie wartości."),
    INCORRECT_TYPE_ERROR("Nieprawidłowy typ. Wprowadź liczby."),

/*
   Stack CalculatorController
*/
    ASSORTMENT("Sortyment"),
    WIDTH("Szerokość"),
    HEIGHT_MEASUREMENT("Pomiar wysokości"),
    CONVERTER("Przelicznik"),
    QUANTITY("Ilość pomiarów"),
    SUM("SUMA"),

    BTN_SUM("Sumuj");


    private String name;

    PolishSubtitles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
