package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 12/03/15.
 */
//Brute Force solution would be to start from 1, and n = nth digit;
// decrease n as per the length of numbers starting from 1, as explained here:
//http://freelancersunite.net/project_euler/project-euler-problem-40/

//This solution is based on logic explained here:http://www.mathblog.dk/project-euler-40-digit-fractional-part-irrational-number/
public class Prob40_NthDigitInFraction {
    static int[] digitArray = new int[8];
    public static void main(String[] args){
        populateDigitArray();
        int product = getNthDigit(1)*getNthDigit(10)*getNthDigit(100)*getNthDigit(1000)*getNthDigit(10000)*getNthDigit(100000)*getNthDigit(1000000);
        System.out.println(product);
    }

    static void populateDigitArray(){
        digitArray[0] = 0;
        int multiplier = 1;
        for(int j = 1; j<=7; j++){
            digitArray[j] = digitArray[j-1] + 9 * multiplier * j;
            multiplier *= 10;
            //System.out.println(digitArray[j]);
        }
    }

    static int getNthDigit(int number){
        int answer = 0;
        int digit = 1;
        if(number<=0){
            return 0;
        }
        while(digit<=7){
            if(number < digitArray[digit] && number > digitArray[digit-1]){
                int n = number - digitArray[digit-1];
                int highestNumOfPrevRange = (int)Math.pow(10, digit-1) - 1;
                int sum = highestNumOfPrevRange + n/digit;
                int rem = n%digit;
                if(rem == 0){
                    return sum %10;
                }
                else{
                    sum += 1;
                    return Integer.parseInt(Character.toString(Integer.toString(sum).charAt(rem-1)));
                }
            }
            digit++;
        }
        return -1;
    }
}
