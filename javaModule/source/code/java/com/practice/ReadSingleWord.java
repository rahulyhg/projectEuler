package com.practice;

import java.util.Scanner;

/**
 * Created by shruti.mantri on 18/02/15.
 */
public class ReadSingleWord {
     /*   Problem statement
        Read a word from the console and write it back to the console

        Input
        A single word consisting only of non-whitespace characters, with a maximum length of 50. Sample input:
        helloworld!

        Output
        The same word that you read from the input. Sample output:
        helloworld!*/
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         System.out.println(input.next());  //input.nextLine() for reading entire line.
     }

}
