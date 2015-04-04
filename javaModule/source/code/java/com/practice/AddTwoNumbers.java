package com.practice;

import java.util.Scanner;

/**
 * Created by shruti.mantri on 18/02/15.
 */
public class AddTwoNumbers {

    // Accept two space separated numbers and output their sum
    public static  void main(String args[]){
        Scanner inputHere = new Scanner(System.in);
        String s = inputHere.nextLine();
        int a = Integer.parseInt(s.split(" ")[0]);
        int b = Integer.parseInt(s.split(" ")[1]);
        System.out.print(a+b);
    }

}
