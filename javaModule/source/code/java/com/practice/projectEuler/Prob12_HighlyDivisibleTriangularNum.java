package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 25/02/15.
 */
public class Prob12_HighlyDivisibleTriangularNum {
    public static void main(String[] args){
        int triNum = 0;
        for(int i = 1; i < 10000000; i++){
            int divisors = 0;
            triNum += i;
            if(i == 1){
                divisors = 1;
                continue;
            }
            int j;
            for(j = 1; j*j < triNum; j++){
                if(triNum%j==0){
                    divisors += 2;
                }
            }
            if(j*j == triNum){
                divisors += 1;
            }
            if(divisors>500){
                System.out.print(triNum);
                break;
            }
        }
    }
}
