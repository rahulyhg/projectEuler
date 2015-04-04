package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 14/03/15.
 */
public class Prob45_TriangularPentagonalHexagonal {
    public static void main(String[] args){
        int i = 144;
        while(true){
            long hexagonal = i * (2*i - 1);
            if(isPentagonal(hexagonal)){
                System.out.println(i + " " + hexagonal);
                break;
            }
            i++;
        }
    }

    static boolean isPentagonal(long p){
        double n = (Math.sqrt(1+ 24*p)+1)/(double)6;
        return (long)n == n;
    }
}
