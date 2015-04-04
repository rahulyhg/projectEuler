package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti.mantri on 19/02/15.
 */
public class GeneratingPrimes {
    public static void main(String[] args){

    }

    private List generatePrimes(int upperLimit){
        List<Integer> primes = new ArrayList<Integer>();
        boolean isPrime;
        int j;

        primes.add(2);

        for (int i = 3; i <= upperLimit; i += 2) {
            j = 0;
            isPrime = true;
            while (primes.get(j)*primes.get(j) <= i) {
                if (i % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
                j++;
            }
            if (isPrime) {
                primes.add(i);
            }
        }

        return primes;
    }
}
