package com.practice.projectEuler;

import java.math.BigInteger;

/**
 * Created by shruti.mantri on 25/02/15.
 */
public class Prob16_PowerDigitSum {
    public static void main(String[] args){
        System.out.print(getSumOfPowerDigit(1000));
    }

     static int getSumOfPowerDigit(int num){
         int sum = 0;
         BigInteger b = BigInteger.ONE;
         BigInteger two = new BigInteger("2");
         for(int i = 1; i <= num; i++){
             b = b.multiply(two);
         }
         String result = b.toString();
         for(int i = 0; i < result.length(); i++){
             sum = sum + (int)(result.charAt(i)-'0');
         }
         return sum;
     }

}
