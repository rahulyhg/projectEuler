package com.practice.projectEuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti.mantri on 14/03/15.
 */
//9-digit & 8-digit pandigital number can not be prime as sum is divisible by 3;
// only 7 digit and 4 digit pandigital primes are possible;
public class Prob41_PandigitalPrime {
    //static List<Integer> primeList = new ArrayList<Integer>();
    public static void main(String[] args){
        for(int i = 7654321; i>=1234567; i--) {
            if(isPrime(i)){
                if(isPandigital(i)){
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    static boolean isPandigital(int n){
        int digits = 0;
        int[] numArray = new int[9];
        while(n > 0){
            digits++;
            if(n%10==0){
                return false;
            }
            if(numArray[(n%10)-1] > 0){
                return false;
            }
            numArray[(n%10)-1]++;
            n /= 10;
        }
        for(int i = 0; i <digits; i++){
            if(numArray[i]!=1){
                return false;
            }
        }
        return true;
    }

    static boolean isPrime(int i){
         boolean isPrime = true;
         for(int j = 2; j*j <= i; j++){
             if(i%j == 0){
                 isPrime = false;
             }
         }
         return isPrime;
    }
}
