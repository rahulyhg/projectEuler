package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 25/02/15.
 */
public class Prob7_10001Prime {
    public static void main(String[] args){
        int count = 1; // for prime number 2;
        for(int i = 3; i<1000000; i+=2){
            boolean prime = true;
            for (int j = 2; j*j <= i ; j++){
                if(i%j ==0){
                    prime = false;
                    break;
                }
            }
            if(prime){
                count++;
                if(count == 10001){
                    System.out.print(i);
                    break;
                }
            }
        }
    }
}
