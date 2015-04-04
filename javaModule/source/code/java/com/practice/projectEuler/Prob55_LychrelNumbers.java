package com.practice.projectEuler;

import java.math.BigInteger;

/**
 * Created by shruti.mantri on 15/03/15.
 */
//Palindrome numbers should also go through this process and generate a palindrome number;
public class Prob55_LychrelNumbers {
    public static void main(String[] args){

        int count = 0;
        for(int i = 10; i<=10000; i++){
            BigInteger b = new BigInteger(String.valueOf(i));
            boolean isPalindrome = false;
            for(int j = 1; j<=50; j++) {
                b = b.add(reverseNumber(b));
                if(isPalindromeNumber(b)){
                    isPalindrome = true;
                    break;
                }
            }
            if(!isPalindrome){
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);
    }

    static BigInteger reverseNumber(BigInteger b){
        BigInteger reverse = BigInteger.ZERO;
        while(b.compareTo(BigInteger.ZERO)>0){
            reverse = reverse.multiply(BigInteger.TEN).add(b.remainder(BigInteger.TEN));
            b = b.divide(BigInteger.TEN);
        }
        return reverse;
    }

    static boolean isPalindromeNumber(BigInteger b){
        return b.compareTo(reverseNumber(b)) == 0;
    }
}
