package com.practice.projectEuler;

import java.math.BigInteger;

/**
 * Created by shruti.mantri on 25/02/15.
 */
public class Prob20_FactorialDigitSum {
    public static void main(String[] args){
        System.out.println(getFactorialDigitSum(100));
    }

    static int getFactorialDigitSum(int num){
        int sumOfDigits = 0;
        BigInteger factorial = BigInteger.ONE;
        for(int i = 1; i <= num; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
            /* if(factorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)){
                factorial = factorial.divide(BigInteger.TEN);
            }*/
            //Not required as using BigInteger.. Found all solutions on net using BigInteger
        }
        String result = String.valueOf(factorial);
        for(int i = 0; i<result.length(); i++){
            sumOfDigits += (int)(result.charAt(i) - '0');
        }
        return sumOfDigits;
    }
}
