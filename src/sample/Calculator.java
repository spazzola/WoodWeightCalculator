package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {


    public static void returnWoodWeight() {

        List<Double> resultsList = new ArrayList<>();
        boolean stop = true;
        int diameter;
        int length;

        System.out.println("Wpisz 0 aby wyjść z programu.");

        do {

            System.out.println("\nPodaj średnicę: ");
            diameter = readIntValue();

            if (diameter == 0) {
                stop = false;
            } else {

                System.out.println("Podaj długość: ");
                length = readIntValue();

                double v = calculatePiceaWeight(diameter, length);

                v = roundNumber(v);

                System.out.println("\nMiąższość = " + v + "\n");

                resultsList.add(v);
            }
        } while (stop);

        double sum = sumList(resultsList);

        System.out.println("\nŁączie m3 = " + sum);
    }

    private static int readIntValue() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static double calculatePiceaWeight(int diameter, int length) {
        double p0 = 0.57723;
        double p1 = 0.006897;
        double p2 = 1.3123;
        double pi = Math.PI;

        return (Math.pow(diameter - (p0 + p1 * Math.pow(diameter, p2)), 2) * pi * length) / 40000;
    }

    public static double calculatePinusWeight(int diameter, int length) {
        double p0 = 0.25017;
        double p1 = 0.001915;
        double p2 = 1.7866;
        double pi = Math.PI;

        return (Math.pow(diameter - (p0 + p1 * Math.pow(diameter, p2)), 2) * pi * length) / 40000;
    }

    public static double calculateLarixWeight(int diameter, int length) {
        double p0 = 0.25017;
        double p1 = 0.001915;
        double p2 = 1.7866;
        double pi = Math.PI;

        return (Math.pow(diameter - (p0 + p1 * Math.pow(diameter, p2)), 2) * pi * length) / 40000;
    }

    public static double calculateFagusWeight(int diameter, int length) {
        double p0 = -0.04088;
        double p1 = 0.16634;
        double p2 = 0.56076;
        double pi = Math.PI;

        return (Math.pow(diameter - (p0 + p1 * Math.pow(diameter, p2)), 2) * pi * length) / 40000;
    }

    public static double calculateQuercusWeight(int diameter, int length) {
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

    private static double sumList(List<Double> resultsList) {
        double result = 0;

        for (double element : resultsList) {
            result += element;
        }
        return result;
    }

    public static double returnWoodWeightFX(int length, int diameter, String woodType) {
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

        v = roundNumber(v);

            return v;
        }
    }
