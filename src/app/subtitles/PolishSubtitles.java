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
    BTN_SWITCH_WINDOW_WD("Obliczanie stosów"),


    /*
       Stack CalculatorController
    */
    ASSORTMENT("Sortyment"),
    WIDTH("Szerokość"),
    HEIGHT_MEASUREMENT("Pomiar wysokości"),
    CONVERTER("Przelicznik"),
    QUANTITY("Ilość pomiarów:"),
    SUM("m3"),

    BTN_SUM("Sumuj"),
    BTN_SWITCH_WINDOW_STCK("Obliczanie pojedyńczych sztuk"),


    /*
       Error messages
    */
    NEGATIVE_VALUE_ERROR("Wartość poniżej 0. Wprowadź dodatnie wartości."),
    INCORRECT_TYPE_ERROR("Nieprawidłowy typ. Wprowadź liczby."),
    CONVERTER_NOT_TYPPED_ERROR("Nie wprowadzono wartości przelicznika");




    private String name;

    PolishSubtitles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
