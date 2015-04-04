package com.practice;

/**
 * Created by shruti.mantri on 10/03/15.
 */
public class StringEncodeDecode_Google {
    public static void main(String[] args){
        System.out.println(Encode("aaabbbb"));
        System.out.println(Encode("a"));
        System.out.println(Decode("a4b3"));
        System.out.println(Decode("a1"));
    }

    static String Encode(String ostr){
        String output = "";
        int count = 0;
        char temp = '\0';
        //output = output+ temp.toString();
        for(int i=0; i<ostr.length(); i++){
            if(temp==ostr.charAt(i)){
                count++;
            }
            else{
                if(count!=0){
                    output = output + count;
                }
                count = 1;
                temp = ostr.charAt(i);
                output = output + ostr.charAt(i);
            }
        }
        output = output + count;
        return output;
    }

    static String Decode(String estr){
        String output = "";
        char temp = '\0';
        String number = "";
        for(int i = 0; i<estr.length(); i++){
            number = "";
            if(estr.charAt(i)>='a' && estr.charAt(i)<='z'){
                temp = estr.charAt(i);
            }
            else{
                while(i<estr.length() && estr.charAt(i)-'0'<=9 && estr.charAt(i)-'0'>0){
                    number += estr.charAt(i);
                    i++;
                }
                i--;
                for(int j = 1; j<=Integer.parseInt(number); j++){
                    output += temp;
                }
            }
        }
        return output;
    }

}
