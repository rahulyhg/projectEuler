package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 25/02/15.
 */
public class Prob10_SummationOfPrimes {
    public static void main(String[] args){
        System.out.println(getSumOfAllPrimesBelow(2000000L));
    }

    static long getSumOfAllPrimesBelow(long num){
        long sum = 2;
        boolean prime;
        for(int i = 3; i<num ; i+=2){
            prime = true;
            for(int j = 2; j*j <= i; j++){
                if(i%j == 0){
                    prime = false;
                    break;
                }
            }
            if(prime){
                sum = sum + i;
            }
        }
        return sum;
    }
}
