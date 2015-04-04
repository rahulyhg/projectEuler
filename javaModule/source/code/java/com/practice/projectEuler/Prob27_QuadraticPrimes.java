package com.practice.projectEuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti.mantri on 08/03/15.
 */
public class Prob27_QuadraticPrimes {
    public static void main(String[] args){
        int aMax = 0, bMax = 0, nMax = 0;
        int[] bPos = allPrimesTill(1000);

        for (int a = -999; a < 1001; a +=2) {
            for (int i = 1; i < bPos.length; i++) {
                for (int j = 0; j < 2; j++) {
                    int n = 0;
                    int sign = (j == 0) ? 1 : -1;
                    int aodd = (bPos[i] % 2 == 0) ? -1 : 0; // Making a even if b is even
                    while (isPrime(Math.abs(n * n + (a + aodd) * n + sign * bPos[i]))) {
                        n++;
                    }

                    if (n > nMax) {
                        aMax = a + aodd;
                        bMax = sign * bPos[i];
                        nMax = n;
                    }
                }
            }
        }
        int product = aMax * bMax;
        System.out.println("Produces a sequence of length: " + nMax);
        System.out.println(aMax + " " + bMax + " " + product);
    }

    static int[] allPrimesTill(int n){
        List<Integer> l = new ArrayList();
        l.add(2);
        for(int i = 3; i<=n; i++){
            boolean isPrime = true;
            for(int j = 2; j<i; j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                l.add(i);
            }
        }
        int[] primes = new int[l.size()];
        for(int i = 0; i<l.size(); i++){
            primes[i] = l.get(i);
        }
        return primes;
    }

    static boolean isPrime(int n){
        boolean prime = true;
        if(n<=1){
            return false;
        }
        for(int i = 2; i*i<=n; i++){
            if(n%i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }
}
