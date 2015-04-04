package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 26/02/15.
 */
public class Prob28_NumberSpiralDiagonals {
    public static void main(String[] args){
        //long num = getNumberSpiralDiagonals(5);
        long num = getNumberSpiralDiagonals(1001);
        System.out.print(num);
    }

    static long getNumberSpiralDiagonals(int num){
        long sum = 1;
        int count = 1;
        for(int i=1; i<num*num;){
            for(int j=1; j<=4; j++){
                i+=2*count;
                //System.out.println(i);
                sum = sum + i;
            }
            count++;
        }
        return sum;
    }
}
