package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 19/02/15.
 */
/*The series, 11 + 22 + 33 + … + 1010 = 10405071317.
Find the last ten digits of the series, 11 + 22 + 33 + … + 10001000.

The properties we want to exploit are
(a*b) % c = ((a % c) * (b % c) )% c
        and
(a+b) % c = ((a % c) + (b % c) )% c.*/

public class Prob48_Last10Digits {
    public static void main(String[] args){
        long result = 0L;
        long modulo = 10000000000L;

        for (int i = 1; i <= 1000; i++) {
            long temp = i;
            for (int j = 1; j < i; j++) {
                temp *= i;
                temp %= modulo;
            }

            result += temp;
            result %= modulo;
        }
        System.out.print(result);
    }
}
