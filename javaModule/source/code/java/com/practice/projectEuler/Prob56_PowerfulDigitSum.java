package com.practice.projectEuler;

import java.math.BigInteger;

/**
 * Created by shruti.mantri on 15/03/15.
 */
public class Prob56_PowerfulDigitSum {
    public static void main(String[] args){
        int result = 0;
        BigInteger limit = new BigInteger("99");
        for(BigInteger i = limit; i.compareTo(BigInteger.ONE)>0; i = i.subtract(BigInteger.ONE)){
            for(int j = 99; j>1; j--){
                BigInteger b = i.pow(j);
                int digitSumOfB = digitSum(b);
                if(digitSumOfB >result){
                    result = digitSumOfB;
                }
                if(numberOfDigits(b)*9<result){
                    break;
                }
            }
        }
        System.out.println(result);
    }

    static int digitSum(BigInteger b){
        int sum = 0;
        while(b.compareTo(BigInteger.ZERO)>0){
            sum += Integer.parseInt((b.remainder(BigInteger.TEN)).toString());
            b = b.divide(BigInteger.TEN);
        }
        return sum;
    }

    static int numberOfDigits(BigInteger b){
        int digits = 0;
        while(b.compareTo(BigInteger.ZERO)>0){
            digits++;
            b = b.divide(BigInteger.TEN);
        }
        return digits;
    }
}
