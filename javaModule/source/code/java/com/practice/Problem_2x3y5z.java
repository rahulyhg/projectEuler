package com.practice;

import java.util.Arrays;

/**
 * Created by shruti.mantri on 03/03/15.
 */
public class Problem_2x3y5z {
    public static void main(String[] args){
        getKElements(25);
    }

    static void getKElements(int k){
        int[] factors = {2, 3, 5};
        int[] elements = new int[k];
        elements[0] = 1;
        int[] nextIndex = new int[factors.length];
        int[] nextFrom = new int[factors.length];
        for (int j = 0; j < factors.length; j++) {
            nextFrom[j] = factors[j];
        }
        for (int i = 1; i < k; i++) {
            int nextNumber = Integer.MAX_VALUE;
            for (int j = 0; j < factors.length; j++) {
                if (nextFrom[j] < nextNumber) {
                    nextNumber = nextFrom[j];
                }
            }
            elements[i] = nextNumber;
            for (int j = 0; j < factors.length; j++) {
                if (nextFrom[j] == nextNumber) {
                    nextIndex[j]++;
                    nextFrom[j] = elements[nextIndex[j]] * factors[j];
                }
            }
        }
        System.out.println(Arrays.toString(elements));
    }
}
