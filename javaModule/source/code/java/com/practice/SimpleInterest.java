package com.practice;

import java.util.Scanner;

/**
 * Created by shruti.mantri on 18/02/15.
 */
    /*Problem statement
        Read the principle, annual rate of interest and number of months of a loan and print out the interest owed (formatted to 2 digits) at the end of the loan term. Simple interest equals priniciple * (yearly-rate-of-interest / 12) * number-of-months

        Input

        Three positive real numbers - principle, rate of interest (in %) and number of months of the loan. Sample input:

        1000 13.5 6
        Output

        The rate of interest formatted to 2 digits after the decimal point. Test cases will be such that total interest is a multiple of 0.01 Sample output:

        67.50
        In the sample case shown above, we calculate interest at the rate of 13.5% per year for a period of 6 months (0.5 years) for a principle of 1000. The total interest is 67.5, which when formatted to 2 decimal places becomes 67.50
*/

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        float principle = Float.parseFloat(s.split(" ")[0]);
        float yearly_rate_of_interest = Float.parseFloat(s.split(" ")[1]);
        float number_of_months = Float.parseFloat(s.split(" ")[2]);
        float simple_interest = (principle * (yearly_rate_of_interest / 12) * number_of_months) / 100;
        System.out.printf("%.2f", simple_interest);
    }

}
