package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 25/02/15.
 */
//O(n^2)
public class Prob5_LCMSmallestMutiple {
    public static void main(String[] args){
        System.out.println(getLCM(20));
    }

    static long getLCM(int num){
        long answer = 1;
        int temp = 1;
        int[] numArray = new int[num];
        for (int i = 0; i < num ; i++){
            numArray[i] = i+1;
        }
        for(int i = 1; i < num; i++){
            answer = answer * numArray[i];
            temp = numArray[i];
            for(int j = i; j < num; j++){
                if(numArray[j]%temp==0){
                    numArray[j] = numArray[j]/temp;
                }
            }
        }
        return answer;
    }
}
