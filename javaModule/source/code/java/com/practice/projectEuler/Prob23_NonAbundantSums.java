package com.practice.projectEuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti.mantri on 14/03/15.
 */

public class Prob23_NonAbundantSums {
    static List<Integer> abundantNumbers = new ArrayList<Integer>();
    public static void main(String[] args){
        fillAbundantNumbers();
        int sum = 0;
        for(int i = 1; i<=28123; i++) {
            for (int j = 0; j < abundantNumbers.size(); j++) {
                if (i < abundantNumbers.get(j)){
                    sum += i;
                    break;
                }
                if (abundantNumbers.contains(i-abundantNumbers.get(j)))
                {
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    static void fillAbundantNumbers(){
        int sumOfNoOfDivisors;
        for(int i=2; i<=28123; i++){
            sumOfNoOfDivisors = 1;
            for(int j = 2; j*j <= i; j++){
                if(j*j == i){
                    sumOfNoOfDivisors += j;
                    break;
                }
                if(i%j == 0){
                    sumOfNoOfDivisors += j;
                    sumOfNoOfDivisors += i/j;
                }
            }
            if(sumOfNoOfDivisors>i){
                abundantNumbers.add(i);
            }
        }
    }
}
