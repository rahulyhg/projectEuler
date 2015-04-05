package com.practice;

/**
 * Created by shruti.mantri on 05/04/15.
 */
public class AllCombinationsOfSum {
    public static void main(String[] args) {
        allSubsets(4, "");
    }

    private static void allSubsets(int num, String out) {
        if(num == 0){
            System.out.println(out);
        } else if (num > 0){
            for(int i = 1; i <= num; i++)
                allSubsets(num - i, out + " " + Integer.toString(i));
        }
    }
}
