package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 04/03/15.
 */
/*
So lets determine the upper bound. We need to find a number x*95 which gives us an x digit number.
We can do this by hand. Since 9^5 = 59049, we need at least 5 digits.
5*(9^5) = 295245, so with 5 digits we can make a 6 digit number. 6*(9^5) = 354294.
So 355000 seems like a reasonable upper bound to use. We could probably tighten is even further if we wanted.
 */
public class Prob30_DigitFifthPower {
    public static void main(String[] args){
        int count = 0;
        int sumOfSuchDigits = 0;
        for(int i=2; i<=355000;i++){
            int sumOfDigits = 0;
            int number = i;
            while(number > 0){
                int digit = number %10;
                number = number/10;
                int digitToFive = 1;
                for(int j = 1; j<=5; j++){
                    digitToFive = digitToFive * digit;
                }
                sumOfDigits += digitToFive;
            }
            if(sumOfDigits == i){
                System.out.println(i);
                count += 1;
                sumOfSuchDigits += i;
            }
        }
        System.out.println(count);
        System.out.println(sumOfSuchDigits);
    }
}
