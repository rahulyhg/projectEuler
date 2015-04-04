package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 26/02/15.
 */
public class Prob58_SpiralPrimes {
    public static void main(String[] args){
        long n = getLessThan10PercentRatio();
        System.out.print(n);
    }

    static long getLessThan10PercentRatio(){
        int num = 1;
        int i = 1;
        long correctSide = 0;
        long count = 1;
        long countPrime = 0;
        for(long side=3; side<=90000; side+=2){
            for(int j=1; j<=4; j++){
                num = num + 2*i;
                count++;
                if(isPrime(num)){
                    countPrime++;
                }
            }
            i++;
            if(((double)countPrime)/count<0.1){    //Too much time consuming if 10 is put
                correctSide = side;
                break;
            }
        }
        return correctSide;
    }

    static boolean isPrime(int num){
        boolean prime = true;
        for (int j=2; j*j<=num ; j++){
            if(num%j ==0){
                prime = false;
                break;
            }
        }
        return prime;
    }

}
