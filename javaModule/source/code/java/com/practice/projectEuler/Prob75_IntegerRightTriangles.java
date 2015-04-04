package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 23/03/15.
 */
public class Prob75_IntegerRightTriangles {
    public static void main(String[] args){
        int count = 0;
        for(long p = 10; p<=1500000; p++){
            if(getNumberOfSolutions(p) == 1){
                count++;
            }
        }
        System.out.println(count);
    }

    static int getNumberOfSolutions(long p){
        int count = 0;
        for(long a = 1; a < p/3; a++){
            float b = (p*p - 2*a*p)/((float)2 * (p-a));
            if((long)b == b){
                count++;
            }
        }
        return count;
    }
}
