package com.practice.projectEuler;

import java.math.BigInteger;

/**
 * Created by shruti.mantri on 15/03/15.
 */
public class Try {
    public static void main(String[] args){
        //related to problem 93
    }

    public static int[] getNextCombination(int k, int n, int[] comb) {
        int i = k - 1;
        ++comb[i];
        while ((i > 0) && (comb[i] >= n - k + 1 + i)) {
            --i;
            ++comb[i];
        }

        if (comb[0] > n - k)
            return null;

        for (i = i + 1; i < k; ++i)
            comb[i] = comb[i - 1] + 1;


        return comb;
    }

}
