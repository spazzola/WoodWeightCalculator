
package sample.service;


/*

Class to calculating single wood weight

*/



public class WoodCalculator {


    public static double returnWoodWeight(int length, int diameter, String woodType) {

        double volume;

        switch (woodType) {
            case "Picea":
                volume = calculatePiceaWeight(diameter, length);
                break;

            case "Pinus":
                volume = calculatePinusWeight(diameter, length);
                break;

            case "Larix":
                volume = calculateLarixWeight(diameter, length);
                break;

            case "Fagus":
                volume = calculateFagusWeight(diameter, length);
                break;

            default:
                volume = calculateQuercusWeight(diameter, length);
                break;
        }
        return roundNumber(volume);

    }

    private static double calculatePiceaWeight(int diameter, int length) {
        double p0 = 0.57723;
        double p1 = 0.006897;
        double p2 = 1.3123;
        double pi = Math.PI;

        return (Math.pow(diameter - (p0 + p1 * Math.pow(diameter, p2)), 2) * pi * length) / 40000;
    }

    private static double calculatePinusWeight(int diameter, int length) {
        double p0 = 0.25017;
        double p1 = 0.001915;
        double p2 = 1.7866;
        double pi = Math.PI;

        return (Math.pow(diameter - (p0 + p1 * Math.pow(diameter, p2)), 2) * pi * length) / 40000;
    }

    private static double calculateLarixWeight(int diameter, int length) {
        double p0 = 0.25017;
        double p1 = 0.001915;
        double p2 = 1.7866;
        double pi = Math.PI;

        return (Math.pow(diameter - (p0 + p1 * Math.pow(diameter, p2)), 2) * pi * length) / 40000;
    }

    private static double calculateFagusWeight(int diameter, int length) {
        double p0 = -0.04088;
        double p1 = 0.16634;
        double p2 = 0.56076;
        double pi = Math.PI;

        return (Math.pow(diameter - (p0 + p1 * Math.pow(diameter, p2)), 2) * pi * length) / 40000;
    }

    private static double calculateQuercusWeight(int diameter, int length) {
        double p0 = 1.2474;
        double p1 = 0.042623;
        double p2 = 1.0623;
        double pi = Math.PI;

        return (Math.pow(diameter - (p0 + p1 * Math.pow(diameter, p2)), 2) * pi * length) / 40000;
    }

    public static double roundNumber(double number) {
        number *= 100;
        number = Math.round(number);
        number /= 100;

        return number;
    }

}



