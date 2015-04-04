package com.practice.utilities;

/**
 * Created by shruti.mantri on 07/03/15.
 */
public class IsPandigital {
    public static void main(String[] args){
        isPandigital(952314678);
        isPandigital(52314);
    }

    private static boolean isPandigital(long n) {
        int digits = 0;
        int count = 0;
        int tmp;

        while (n > 0) {
            tmp = digits;
            digits = digits | 1 << (int)((n % 10) - 1);
            if (tmp == digits || (n%10) == 0) {
                //Checks if the digit was zero or a repeated one.
                return false;
            }

            count++;
            n /= 10;
        }
        return digits == (1 << count) - 1;
    }
}
