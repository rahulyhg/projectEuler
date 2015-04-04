package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 08/03/15.
 */
public class Prob34_DigitFactorials {
    public static void main(String[] args){
        int[] fact = new int[10];
        for(int i = 0; i<=9; i++){
            fact[i] = factorial(i);
        }
        int sumOfSuchNumbers = 0;
        for(int i = 10; i< 2540161; i++){
            int number = i;
            int sumOfFactorials = 0;
            while(number>0){
                sumOfFactorials += fact[number%10];
                number /= 10;
            }
            if(sumOfFactorials == i){
                System.out.println(i);
                sumOfSuchNumbers += i;
            }
        }
        System.out.println(sumOfSuchNumbers);
    }

    static int factorial(int n){
        if(n==0){
            return 1;
        }
        int fact = n;
        for(int i = 1; i<n; i++){
            fact *= i;
        }
        return fact;
    }
}
