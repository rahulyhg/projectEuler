package com.practice.projectEuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti.mantri on 10/03/15.
 */
public class Prob35_CircularPrimes {
    static List<Integer> primes = new ArrayList<Integer>();   // Here, planning to use array list(additions should be at the end), as searching is not much
                            // and mostly it will be sequential traversing
    public static void main(String[] args){
        fillPrimes();
        primes.remove(new Integer(2));
        primes.remove(new Integer(5));
        int countCircularPrimes = 2;
        while(primes.size()>0){
            countCircularPrimes += checkCircularPrime(primes.get(0));
        }
        System.out.println("No. of circular primes below 1000000 : " + countCircularPrimes);
    }

    static void fillPrimes(){
        primes.add(2);
        for(int i = 3; i<1000000; i++){
            boolean isPrime = true;
            for(int j = 2; j*j<=i; j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primes.add(i);
            }
        }
    }

    static int checkCircularPrime(int prime){
        int count = 0;
        int multiplier = 1;
        int n = prime;
        int d =0;
        while(n>0){
            d = n%10;
            if(d%2==0 || d==5){
                primes.remove(new Integer(prime));
                return 0;
            }
            multiplier *= 10;
            count+= 1;
            n /= 10;
        }
        multiplier /= 10;
        List<Integer> foundCircularPrimes = new ArrayList<Integer>();
        n = prime;
        int noOfCircularPrimes = 0;
        for(int i = 0; i<count; i++){
            if(primes.contains(new Integer(n))){
                foundCircularPrimes.add(n);
                primes.remove(new Integer(n));
                noOfCircularPrimes++;
                n = multiplier * (n%10) + n/10;
            }
            else if(!foundCircularPrimes.contains(n)){
                return 0;
            }
        }
        return noOfCircularPrimes;
    }
}
