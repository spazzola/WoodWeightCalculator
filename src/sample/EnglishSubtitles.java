package sample;

public enum EnglishSubtitles {



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
    BTN_RESET("Reset");


    private String name;

    EnglishSubtitles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
