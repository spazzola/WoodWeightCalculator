package sample.service;


public class WoodCalculator {


    public static double returnWoodWeight(int length, int diameter, String woodType) {
        double v;

        if (woodType.equals("Picea")) {
            v = calculatePiceaWeight(diameter, length);

        }else if (woodType.equals("Pinus")) {
            v = calculatePinusWeight(diameter, length);

        }else if (woodType.equals("Larix")) {
            v = calculateLarixWeight(diameter, length);

        }else if (woodType.equals("Fagus")) {
            v = calculateFagusWeight(diameter, length);

        }else {
            v = calculateQuercusWeight(diameter, length);
        }

        return roundNumber(v);
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

/*
    private static double CcalculatePiceaWeight(String d, String l) {
        /*
        double p0 = 0.57723;
        double p1 = 0.006897;
        double p2 = 1.3123;
        double pi = Math.PI;


        BigDecimal p0 = new BigDecimal("0.57723");
        BigDecimal p1 = new BigDecimal("0.006897");
        BigDecimal p2 = new BigDecimal("1.3123");
        BigDecimal pi = new BigDecimal(Math.PI);

        BigDecimal diameter = new BigDecimal(d);
        BigDecimal length = new BigDecimal(l);



        return (Math.pow(diameter - (p0 + p1 * Math.pow(diameter, p2)), 2) * pi * length) / 40000;
    }
     */
}


