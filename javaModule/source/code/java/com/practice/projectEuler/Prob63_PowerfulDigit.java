package com.practice.projectEuler;

import java.math.BigInteger;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;

/**
 * Created by shruti.mantri on 15/03/15.
 */
//By Brute Force
/*public class Prob63_PowerfulDigit {
    //static HashSet<BigInteger> s = new HashSet<BigInteger>(); Every number will come only once where x ^n has digits = n
    public static void main(String[] args){
        int count = 0;
        for(BigInteger i = BigInteger.ONE; i.compareTo(BigInteger.TEN)<0; i = i.add(BigInteger.ONE)){
            int j = 1;
            BigInteger pow = i.pow(j);
            while(noOfDigits(pow)==j){
                count++;
                j++;
                pow = i.pow(j);
            }
        }
        System.out.println(count);
    }

    static int noOfDigits(BigInteger p){
        int digits = 0;
        while(p.compareTo(BigInteger.ZERO)>0){
            digits++;
            p = p.divide(BigInteger.TEN);
        }
        return digits;
    }

}*/

//As per problem analysis: http://www.mathblog.dk/project-euler-63-n-digit-nth-power/
public class Prob63_PowerfulDigit{
    public static void main(String[] args){
        int result = 0;
        int lower = 1;
        int n = 1;

        while (lower < 10) {
            lower = (int)Math.ceil(Math.pow(10,(n-1.0)/n));
            result += 10 - lower;
            n++;
        }
        System.out.println(result);
    }
}