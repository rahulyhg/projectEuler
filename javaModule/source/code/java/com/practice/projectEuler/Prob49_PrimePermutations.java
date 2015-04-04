package com.practice.projectEuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti.mantri on 15/03/15.
 */
public class Prob49_PrimePermutations {
    static List<Integer> primeNumbers = new ArrayList<Integer>();
    public static void main(String[] args){
        fillPrimeNumbers(1489, 9999);
        boolean continueFlag = true;
        for(int i = 0; i<primeNumbers.size(); i++){
            int prime1 = primeNumbers.get(i);
            for(int j = i+1; j<primeNumbers.size(); j++){
                int prime2 = primeNumbers.get(j);
                if(containsSameDigits(prime1, prime2)) {
                    int prime3 = prime2 + (prime2 - prime1);
                    if (primeNumbers.contains(prime3)) {
                        if(containsSameDigits(prime1, prime3)){
                            concatenate(prime1, prime2, prime3);
                            continueFlag = false;
                            break;
                        }
                    }
                }
            }
            if(!continueFlag){
                break;
            }
        }
    }

    static void fillPrimeNumbers(int start, int end){
        for(int i = start; i<= end; i++){
            boolean isPrime = true;
            for(int j = 2; j*j <=i; j++){
                if(i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primeNumbers.add(i);
            }
        }
    }

    static boolean containsSameDigits(int num1, int num2){
        int[] numArray = new int[10];
        while(num1 > 0){
            numArray[num1%10]++;
            num1 /= 10;
        }
        while(num2 > 0){
            numArray[num2%10]--;
            num2 /= 10;
        }
        for(int i = 0; i<=9; i++){
            if(numArray[i]!=0){
                return false;
            }
        }
        return true;
    }

    static void concatenate(int num1, int num2, int num3){
        long answer = 0;
        int multiplier = 1;
        answer = num1;
        int temp = num2;
        while(num2>0){
            multiplier *= 10;
            num2 /= 10;
        }
        answer = answer * multiplier + temp;
        temp = num3;
        multiplier = 1;
        while(num3>0){
            multiplier *= 10;
            num3 /= 10;
        }
        answer = answer * multiplier + temp;
        System.out.println(answer);
    }
}
