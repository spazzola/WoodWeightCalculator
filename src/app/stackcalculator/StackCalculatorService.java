
package app.stackcalculator;

import app.woodcalculator.WoodCalculatorService;

import java.util.ArrayList;
import java.util.List;

/***************************************
*                                      *
*  Class to calculating stacks weight  *
*                                      *
***************************************/

public class StackCalculatorService {


    //TODO add methods to calculate stacks

    public static double returnStackWeight(double woodLength, double stackWidth, List<Double> heights) {
        double coefficient = 0.64;
        double averageHeight = returnAverageHeight(heights);

        double v = woodLength * stackWidth * averageHeight * coefficient;

        return WoodCalculatorService.roundNumber(v);
    }

    private static double returnAverageHeight(List<Double> heights) {
        double sum = 0.0;

        for (Double height : heights) {
            sum += height;
        }
        double averageHeight = sum / heights.size();

        return WoodCalculatorService.roundNumber(averageHeight);
    }

}

