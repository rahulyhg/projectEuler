package com.practice;

/**
 * Created by shruti.mantri on 10/02/15.
 */
public class MinSquares {
    public static void main(String[] args){
            System.out.println(total(12));
    }

    static int total(int n){
        if(n<=2) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            int minv = 100;
            for(int j=1; j<=Math.sqrt(i); ++j){
                minv  = Math.min(minv, 1+dp[i-j*j]);    //1 = dp[j*j]
            }
            dp[i] = minv;
        }
        return dp[n];
    }
}

