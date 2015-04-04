package com.practice.projectEuler;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by shruti.mantri on 07/03/15.
 */
// Place where java is searching for files: System.out.println(System.getProperty("user.dir"));
public class Prob22_NamesScores {
    public static void main(String[] args) throws Exception{
        //System.out.println(System.getProperty("user.dir"));
        String fileContent = readFile("javaModule/source/code/java/com/practice/projectEuler/files/names.txt");
        String[] names = fileContent.split(",");
        for(int i = 0; i<names.length; i++){
            names[i] = names[i].trim();
            names[i] = names[i].replaceAll("\"","");
        }
        String[] sortedNames = MergeSort(names);
        //String[] sortedNames = names;
        //Arrays.sort(names);
        long sumResult = 0;
        for(int i = 0; i< sortedNames.length; i++){

            sumResult += (i+1)*sum(sortedNames[i]);
            //System.out.println(sumResult + " " + sortedNames[i] + " " + sum(sortedNames[i]));
        }
        System.out.println(sumResult);
    }

    private static long sum(String s){
        long result = 0;
        for(int i = 0; i<s.length(); i++){
            result += (s.charAt(i)-'A')+1;
        }
        return result;
    }

    private static String[] MergeSort(String[] Strings) {
        if (Strings.length <= 1) {
            return Strings;
        }

        int firstPart = Strings.length / 2;
        String[] Strings1 = new String[firstPart];
        String[] Strings2 = new String[Strings.length - firstPart];

        String[] sorted = new String[Strings.length];

        // Split the array into two;
        for (int i = 0; i < firstPart; i++) {
            Strings1[i] = Strings[i];
        }

        for (int i = firstPart; i < Strings.length; i++) {
            Strings2[i - firstPart] = Strings[i];
        }

        Strings1 = MergeSort(Strings1);
        Strings2 = MergeSort(Strings2);

        int j = 0;
        int k = 0;

        for (int i = 0; i < sorted.length; i++) {
            if(j == Strings1.length){
                sorted[i] = Strings2[k];
                k++;
            } else if(k == Strings2.length){
                sorted[i] = Strings1[j];
                j++;
            }else if(CompareStrings(Strings1[j], Strings2[k])){
                sorted[i] = Strings1[j];
                j++;
            } else {
                sorted[i] = Strings2[k];
                k++;
            }
        }

        return sorted;
    }

    private static boolean CompareStrings(String str1, String str2) {
        int i = 0;
        while (i < str1.length() && i < str2.length()) {
            if (str1.charAt(i) == str2.charAt(i)) {
                i++;
            } else {
                return str1.charAt(i) < str2.charAt(i);
            }
        }
        return str1.length() <= str2.length();
    }

    static String readFile(String path) throws Exception{
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
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
