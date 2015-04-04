package com.practice;

/**
 * Created by shruti.mantri on 10/02/15.
 */
public class StringCombinations {
    public static void main(String[] args){
        System.out.println(getCombinationsNumber("723"));
    }
    public static int getCombinationsNumber(String s){
        if (s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1 ; i < s.length() ; i++){
            int num = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
            dp[i] += dp[i - 1];
            if (num <= 25) {
                dp[i] += i == 1 ? 1 : dp[i - 2];
            }
        }
        return dp[s.length()-1];
    }
}
