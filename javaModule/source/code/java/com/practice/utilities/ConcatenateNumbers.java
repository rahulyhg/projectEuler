package com.practice.utilities;

/**
 * Created by shruti.mantri on 07/03/15.
 */
public class ConcatenateNumbers {
    public static void main(String[] args){
        concat(100, 503);
    }

    private static long concat(long a, long b) {
        long c = b;
        while (c > 0) {
            a *= 10;
            c /= 10;
        }
        return a + b;
    }
}
