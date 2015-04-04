package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 25/02/15.
 */

//Recursive solution is also possible: http://www.mathblog.dk/uva-100-3n-plus-1-problem/
public class Prob14_LongestCollatzSequence {
    static long num = 1000000;
    public static void main(String[] args){
        long chainSize = 0;
        long count;
        long number = 0;
        for(long i = 2; i <= num; i++){
            long j = i;
            count = 0;
            while(j!=1){
                if(j%2==0){
                    j = j/2;
                }
                else{
                    j = 3*j + 1;
                }
                count += 1;
            }
            if(chainSize < count){
                chainSize = count;
                number = i;
            }
        }
        System.out.println(chainSize + "," + number);
    }
}
