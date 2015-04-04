package com.practice;

/**
 * Created by shruti.mantri on 11/02/15.
 */
public class ConjugateWithSum{
    public static void main(String args[]){
        int arr1[] ={5,7,2,9,3,1,6};
        int arr[] = {1,2,3,4};
        getArr(arr);

    }

    public static void getArr(int []arr){
        int sum = 0;
        for(int i =0;i<arr.length;i++)
            sum += arr[i];

        for(int i =0;i<arr.length;i++)
            arr[i] = sum + ~arr[i] +1;

        for(int i =0;i<arr.length;i++)
            System.out.println(arr[i]);
    }


}