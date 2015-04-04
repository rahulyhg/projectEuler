package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 15/03/15.
 */
//Good explanation at http://www.mathblog.dk/project-euler-38-pandigital-multiplying-fixed-number/
public class Prob38_PandigitalMultiples {
    public static void main(String[] args){
        for(long i = 9487; i>=9234; i--){
            long j = concat(i, i*2);
            if(isPandigital(j)){
                System.out.println(j);
                break;
            }
        }
    }

    static long concat(long i, long j){
        long temp = j;
        while(j > 0){
            i = i*10;
            j /= 10;
        }
        return i + temp;
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
