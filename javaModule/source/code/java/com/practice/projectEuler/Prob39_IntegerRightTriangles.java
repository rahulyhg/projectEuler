package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 14/03/15.
 */
public class Prob39_IntegerRightTriangles {
    public static void main(String[] args){
        int maxNoOfSolutions = 0;
        int perimeter = 0;
        for(int p = 10; p<=1000; p++) {
            int noOfSolutions = 0;
            for(int a = 1; a < p/3; a++){
                double b = (double)p * (p - 2*a)/(2*(p-a));
                //check if((p * (p - 2*a))%(2*(p-a))==0)
                if(b == (int)b){
                    noOfSolutions++;
                }
            }
            if(noOfSolutions > maxNoOfSolutions){
                maxNoOfSolutions = noOfSolutions;
                perimeter = p;
            }
        }
        System.out.println(perimeter + " " +    maxNoOfSolutions);
    }
}
