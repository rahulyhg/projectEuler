package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 26/02/15.
 */

//http://www.mathblog.dk/project-euler-29-distinct-terms-sequence-ab/
//Check the pen and paper way..

//As of now, the solution is wrong.. as it does not take case 8^6 = 4^9 type of cases..
//As explained by : http://stackoverflow.com/questions/2147692/project-euler-29 Jason Orendorff

public class Prob29_DistinctPowers {
    static int MAX = 100;
    static int[] a = new int[101];

    public static void main(String[] args){
        int res=(MAX-1)*(MAX-1);
        for(int i=2; i<=MAX; i++){
            a[i]=99;
        }
        for(int i=2;i<MAX;i++){
            for(int j=i*i;j<=MAX;j=j*i){
                int temp = (int)(MAX*(Math.log(i)/Math.log(j)));
                a[j] =((MAX-1)-a[j])<temp?(MAX-1)-temp+1:a[j];
            }
        }
        int sum = 0;
        for(int i=2; i<=MAX; i++){
            sum = sum + a[i];
        }
        System.out.println(sum);
    }
}
