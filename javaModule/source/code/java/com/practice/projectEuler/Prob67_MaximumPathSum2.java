package com.practice.projectEuler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by shruti.mantri on 08/03/15.
 */
//Exactly same as problem 18
public class Prob67_MaximumPathSum2 {
    public static void main(String[] args) throws Exception{
        String filePath = "javaModule/source/code/java/com/practice/projectEuler/files/p067_triangle.txt";
        int[][] inputTriangle = readInput(filePath);
        for(int i = inputTriangle.length-2; i>=0; i--){
            for(int j = 0; j<=i; j++){
                inputTriangle[i][j] += Math.max(inputTriangle[i+1][j], inputTriangle[i+1][j+1]);
            }
        }
        System.out.print(inputTriangle[0][0]);
    }

    static int[][] readInput(String filePath) throws Exception{
        FileInputStream fIn = new FileInputStream(filePath);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(fIn));
        int numberOfLines = 0;
        while(br1.readLine()!=null){
            numberOfLines++;
        }
        int[][] inputTriangle = new int[numberOfLines][numberOfLines];
        fIn.getChannel().position(0);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fIn));
        String line = null;
        int  i = 0;
        while((line = br2.readLine())!=null){
            line = line.trim();
            String[] numbers = line.split(" ");
            for(int j=0; j<=i; j++){
                inputTriangle[i][j] = Integer.parseInt(numbers[j]);
            }
            i++;
        }
        return inputTriangle;
    }
}
