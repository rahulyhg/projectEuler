package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 19/02/15.
 */
public class Prob2_SumOfEvenFibonacci {
    public static void main(String[] args){
        long i = 1L;
        long j = 2L;
        long sum = 2L;
        long limit = 4000000L;
        boolean a = true;
        while(i<limit && j<limit){
            if(a){
                i = i+j;
                a = false;
                if(i%2==0){
                    sum = sum+i;
                }
            }
            else{
                j = i+j;
                a = true;
                if(j%2==0){
                    sum = sum+j;
                }
            }
        }
        System.out.print(sum);
    }
}
