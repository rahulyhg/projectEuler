package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 25/02/15.
 */
public class Prob21_AmicableNumbers {
    public static void main(String[] args){
        System.out.println(sumOfAllAmicableNumbersUnder(10000));
    }

    static int sumOfAllAmicableNumbersUnder(int num){
        int count = 0;
        int a,b;
        for(int i = 1; i<=num; i++){
            a = getSumOfDivisors(i);
            if(i==getSumOfDivisors(a) && i!=a){
                System.out.println("Amicable Number Pair : " + i + ","+ a);
                count+=i;
            }
        }
        return count;
    }

    static int getSumOfDivisors(int num){
        int sum = 0;
        for(int i = 1; i*i<=num; i++){
            if(i*i==num){
                sum += i;
            }
            else if(num%i==0){
                sum += i;
                if(i!=1){
                    sum += num/i;
                }
            }
        }
        return sum;
    }
}
