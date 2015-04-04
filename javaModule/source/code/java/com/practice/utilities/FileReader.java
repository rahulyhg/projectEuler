package com.practice.utilities;

import java.io.BufferedReader;

/**
 * Created by shruti.mantri on 07/03/15.
 */
// Place where java is searching for files: System.out.println(System.getProperty("user.dir"));
public class FileReader {
    public static void main(String[] args) throws Exception{
        System.out.println(System.getProperty("user.dir"));
        //System.out.print(readFile("javaModule/source/code/java/com/practice/projectEuler/files/names.txt"));
        System.out.print(readFile("javaModule/source/code/java/com/practice/projectEuler/Prob58_SpiralPrimes.java"));
    }

    static String readFile(String path) throws Exception{
        java.io.FileReader fr = new java.io.FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        //FileInputStream fr = new FileInputStream(path);
        //BufferedReader br = new BufferedReader(new InputStreamReader(fr));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String everything = sb.toString();
        return everything;
    }
}
