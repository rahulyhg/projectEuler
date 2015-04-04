package com.practice.projectEuler;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti.mantri on 14/03/15.
 */
public class Prob42_CodedTriangleNumbers {
    public static void main(String[] args) throws Exception{
        String filePath = "javaModule/source/code/java/com/practice/projectEuler/files/p042_words.txt";
        String lineOfWords = readFileInput(filePath);
        String[] words = lineOfWords.replace('\n','\0').split(",");
        int noOfTriangleWords = 0;
        for(int i = 0; i<words.length; i++){
            words[i] = words[i].split("\"")[1];
            int sumOfWord = sum(words[i]);
            //System.out.println(words[i] + " " + sumOfWord);
            double t = (Math.sqrt(1 + 8*sumOfWord) - 1)/(double)2;
            if(t == (int)t){
                noOfTriangleWords++;
            }
        }
        System.out.println(noOfTriangleWords);
    }

    static int sum(String s){
        int sum = 0;
        for(int i = 0; i<s.length(); i++){
            sum += (s.charAt(i)-'A')+1;
        }
        return sum;
    }

    static String readFileInput(String filePath) throws Exception{
        java.io.FileReader fr = new java.io.FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String line1 = "";
        while((line = br.readLine())!=null){
            line1+= line;
        }
        return line1;
    }
}
