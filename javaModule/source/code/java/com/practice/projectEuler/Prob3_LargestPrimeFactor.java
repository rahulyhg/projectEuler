package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 19/02/15.
 */
public class Prob3_LargestPrimeFactor {
    public static void main(String[] args){
        final long numm = 600851475143L;
        long largestFact = 0;
        long[] factors = new long[2];

        for (long i = 2; i * i < numm; i++) {
            if (numm % i == 0) { // It is a divisor
                factors[0] = i;
                factors[1] = numm / i;

                for (int k = 0; k < 2; k++) {
                    boolean isPrime = true;
                    for (long j = 2; j * j <  factors[k]; j++) {
                        if (factors[k] % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime && factors[k] > largestFact) {
                        largestFact = factors[k];
                    }
                }
            }
        }
        System.out.print(largestFact);
    }
}
