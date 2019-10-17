<<<<<<< HEAD

package sample.service;
=======
package sample;
>>>>>>> 77e79570ec45d22ac156e42c6602ccc0bba3ff6e

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD

/*

Class to calculating stacks weight

 */

public class StackCalculator {

    //TODO add methods to calculate stacks
=======
public class StackCalculator {

>>>>>>> 77e79570ec45d22ac156e42c6602ccc0bba3ff6e

    public static double returnStackWeight(double woodLength, double stackWidth, List<Double> heights) {
        double coefficient = 0.64;
        double averageHeight = returnAverageHeight(heights);

        double v = woodLength * stackWidth * averageHeight * coefficient;

        return WoodCalculator.roundNumber(v);
    }

    private static double returnAverageHeight(List<Double> heights) {
        double sum = 0.0;

        for (Double height : heights) {
            sum += height;
        }
        double averageHeight = sum / heights.size();

        return WoodCalculator.roundNumber(averageHeight);
    }



<<<<<<< HEAD

=======
>>>>>>> 77e79570ec45d22ac156e42c6602ccc0bba3ff6e
    public static void main(String[] args) {

        List<Double> test = new ArrayList<>();

        test.add(0.85);
        test.add(1.09);
        test.add(1.47);
        test.add(1.54);
        test.add(1.95);
        test.add(2.76);
        test.add(3.34);
        test.add(3.50);
        test.add(3.02);
        test.add(3.15);
        test.add(3.05);
        test.add(2.85);
        test.add(2.34);
        test.add(1.3);
        test.add(0.3);

        System.out.println(returnStackWeight(2.5, 13.7, test));
    }
<<<<<<< HEAD

=======
>>>>>>> 77e79570ec45d22ac156e42c6602ccc0bba3ff6e
}

