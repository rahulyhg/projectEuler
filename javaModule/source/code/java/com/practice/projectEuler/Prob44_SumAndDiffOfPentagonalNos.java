package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 14/03/15.
 */
public class Prob44_SumAndDiffOfPentagonalNos {
    public static void main(String[] args){
        int i = 1;
        int m , n, k=0 , l=0;
        int minDiff = Integer.MAX_VALUE;
        boolean continueFlag = true;
        while(continueFlag){
            i++;
            m = i * (3*i - 1)/2;
            for(int j = i-1; j>0; j--){
                n = j * (3*j - 1)/2;
                if(isPentagonal(m + n) && isPentagonal(m - n)){
                    if((m - n)<minDiff){
                        minDiff = m-n;
                        k = i; l = j;
                    }
                }
                if((minDiff > (m - n)) && (j == i -1) && (minDiff != Integer.MAX_VALUE)){
                    continueFlag = false;
                }
            }
        }
        System.out.println(minDiff + " " + k + " " + l);
    }

    static boolean isPentagonal(int m){
        double i = (1 + Math.sqrt(1+ 24*m))/(double)6;
        return (int)i == i;
    }
}
