package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 20/02/15.
 */
public class Prob6_SumSquareDiff {
    public static void main(String[] args){
        System.out.print(getSumSquareDifference(100));
    }

    static long getSumSquareDifference(long n){
        long sumOfSquares = (n * (n+1) * (2*n + 1))/6;
        long squareOfSum = (long)Math.pow(((n * (n+1))/2), 2L);
        return squareOfSum - sumOfSquares;
    }
}
