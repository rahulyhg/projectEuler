package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 08/03/15.
 */
public class Prob24_MillionthLexicographicPermutation {
    public static void main(String[] args){
        int remain = 1000000-1;
        int[] numbers = {0,1,2,3,4,5,6,7,8,9};
        String permNum = "";
        int N = numbers.length;
        for(int i =1; i<N; i++){
            int j = remain/ factorial(N-i);
            remain = remain % factorial(N-i);
            permNum = permNum + numbers[j];
            for(int k =j+1; k<N; k++){
                numbers[k-1] = numbers[k];
            }
            numbers[N-1]=-1;
            if(remain==0){
                break;
            }
        }
        for(int i = 0; i<N; i++){
            if(numbers[i]!=-1){
                permNum = permNum + numbers[i];
            }
        }
        System.out.print(permNum);
    }

    static int factorial(int n){
        if(n<0){
            return 0;
        }
        int p =1;
        for(int i = 1;i <=n; i++){
            p *= i;
        }
        return p;
    }
}
