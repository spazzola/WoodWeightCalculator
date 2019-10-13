package sample;

public enum PolishSubtitles {

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
    BTN_RESET("Zeruj");


    private String name;

    PolishSubtitles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
