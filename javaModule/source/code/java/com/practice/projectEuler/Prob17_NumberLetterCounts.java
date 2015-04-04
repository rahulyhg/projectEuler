package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 25/02/15.
 */
public class Prob17_NumberLetterCounts {
    static int ONE = 3;
    static int TWO = 3;
    static int THREE = 5;
    static int FOUR = 4;
    static int FIVE = 4;
    static int SIX = 3;
    static int SEVEN = 5;
    static int EIGHT = 5;
    static int NINE = 4;
    static int TEN = 3;
    static int ELEVEN = 6;
    static int TWELVE = 6;
    static int THIRTEEN = 8;
    static int FOURTEEN = 8;
    static int FIFTEEN = 7;
    static int SIXTEEN = 7;
    static int SEVENTEEN = 9;
    static int EIGHTEEN = 8;
    static int NINETEEN = 8;
    static int TWENTY = 6;
    static int THIRTY = 6;
    static int FORTY = 5;
    static int FIFTY = 5;
    static int SIXTY = 5;
    static int SEVENTY = 7;
    static int EIGHTY = 6;
    static int NINETY = 6;
    static int HUNDRED = 7;
    static int THOUSAND = 8;
    static int HUNDREDAND = 10;
    public static void main(String[] args){
        System.out.println(getTheNumberOfLetters(1000));
    }

    static long getTheNumberOfLetters(int num){
        long sum = 0;
        for(int i = 1; i<= num; i++){
            System.out.println(i);
            if(i<=20){      //Less than 20
                sum = sum + getConvertedNumber(i);
            }
            else if(i<100){
                if(i%10==0){
                    sum = sum + getConvertedNumber(i);
                }
                else{
                    sum = sum + getConvertedNumber(i/10*10) + getConvertedNumber(i%10);
                }
            }
            else if(i%100==0 && i<1000){
                sum = sum + getConvertedNumber(i/100) + HUNDRED;
            }
            else if(i/1000==0 && i/100>=1){
                sum = sum + getConvertedNumber(i/100) + HUNDREDAND;
                if((i%100)%10==0 || (i%100)<20){
                    sum = sum + getConvertedNumber(i%100);
                }
                else{
                    sum = sum + getConvertedNumber((i%100)/10*10) + getConvertedNumber((i%100)%10);
                }
            }
            else if(i%1000==0){
                sum = sum + getConvertedNumber(i/1000) + getConvertedNumber(1000);
            }
        }
        return sum;
    }

    static int getConvertedNumber(int i){
        switch(i){
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            case 8:
                return EIGHT;
            case 9:
                return NINE;
            case 10:
                return TEN;
            case 11:
                return ELEVEN;
            case 12:
                return TWELVE;
            case 13:
                return THIRTEEN;
            case 14:
                return FOURTEEN;
            case 15:
                return FIFTEEN;
            case 16:
                return SIXTEEN;
            case 17:
                return SEVENTEEN;
            case 18:
                return EIGHTEEN;
            case 19:
                return NINETEEN;
            case 20:
                return TWENTY;
            case 30:
                return THIRTY;
            case 40:
                return FORTY;
            case 50:
                return FIFTY;
            case 60:
                return SIXTY;
            case 70:
                return SEVENTY;
            case 80:
                return EIGHTY;
            case 90:
                return NINETY;
            case 100:
                return HUNDRED;
            case 1000:
                return THOUSAND;
            default:
                System.out.println("Invalid number "+ i);
                return -1;
        }
    }
}
