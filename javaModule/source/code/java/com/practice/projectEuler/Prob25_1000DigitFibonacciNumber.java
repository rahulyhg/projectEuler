package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 25/02/15.
 */

//http://www.coderanch.com/t/497962/java/java/Project-Euler
//Answer by Ashish Schottky
/*
Consider the golden ratio as (1+sqrt(5))/2=phi
Comparin the number of digits to power of 10, we can see in general will have x digits.
So any number which has 1000 digits will be greater than 10**999.

nth fibonacci number is given by
(phi**n)/sqrt(5) . SO according to our conditions:
(phi**n)/sqrt(5) > 10**999
solving this inequality gives us n=4782.
 */
public class Prob25_1000DigitFibonacciNumber {
    public static void main(String[] args){
        double phi = (1 + Math.sqrt(5)) / 2;
        double divider = Math.sqrt(5);
        int digits = 1000;
        int power = digits - 1;
        int n = (int) ((power + Math.log10(divider)) / Math.log10(phi)) + 1;
        System.out.println(n);
    }
}
