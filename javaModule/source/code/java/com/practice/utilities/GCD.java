package com.practice.utilities;

/**
 * Created by shruti.mantri on 08/03/15.
 */
public class GCD {
    public static void main(String[] args){
        gcd(5, 10);
    }

    public static int gcd(int a, int b) {
        int y = 0;
        int x = 0;

        if (a > b) {
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }

        while (x % y != 0) {
            int temp = x;
            x = y;
            y = temp % x;
        }
        return y;
    }
}
