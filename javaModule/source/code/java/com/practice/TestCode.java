package com.practice;

/**
 * Created by shruti.mantri on 05/04/15.
 */
public class TestCode {
    public static void main(String[] args){
        for(int i = 1; i<=20; i++) {
            System.out.println( i + " : " +num_squares(i));
        }
    }

    static int num_squares(int n){
        int[] table = new int[n+1];
        int max = (int)Math.floor(Math.sqrt(n));
        int squared;

        for (int i=0; i<=n; i++){
            table[i] = i;
        }
        for (int i=1; i<=max; i++){
            squared = (int)Math.pow(i,2);
            for (int j=squared; j<=n; j++){
                table[j] = Math.min(table[j], table[j - squared] + 1);
            }
        }
        return table[n];
    }
}
