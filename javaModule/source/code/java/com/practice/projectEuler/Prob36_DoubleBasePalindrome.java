package com.practice.projectEuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti.mantri on 12/03/15.
 */
public class Prob36_DoubleBasePalindrome {
    public static void main(String[] args){
        generatePalindromesInBase10();
    }

    static void generatePalindromesInBase10(){
        final int limit = 1000000;
        int result = 0;
        int number;
        for(int j = 0; j<2; j++) {
            boolean isOdd = (j%2==0?false:true);
            int i = 1;
            while((number = createPalindrome(i, isOdd, 10))<limit) {
                if (isPalindrome(number, 2)) {
                    result += number;
                }
                i++;
            }
        }
        System.out.println(result);
    }

    static int createPalindrome(int input, boolean isOdd, int base){
        int palin = input;
        if(isOdd){
            input /= base;
        }
        while(input>0){
            palin = palin * base + (input % base);
            input /= base;
        }
        return palin;
    }

    static boolean isPalindrome(int number, int base){
        int n = number;
        int reversed = 0;
        while(n>0){
            reversed = reversed * base + (n % base);
            n /= base;
        }
        return number == reversed;
    }
}
