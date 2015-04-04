package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 25/02/15.
 */
public class Prob19_CountingSundays {
    //4,6,9,11
    //2
    public static void main(String[] args){
        int count = 0;
        long numberOfDays = 0;
        for(int year = 1900; year <= 2000; year++){
            for(int month = 1; month<=12; month++){
                for(int dayOfMonth = 1; dayOfMonth <= getTotalDaysInMonth(month, year); dayOfMonth++){
                    numberOfDays++;
                    if(numberOfDays%7==0 && dayOfMonth == 1 && year>=1901){
                        count++;
                    }
                }
            }
        }
        System.out.print(count);
    }

    static int getTotalDaysInMonth(int month, int year){
        if(month == 4 || month == 6 || month==9 || month==11){
            return 30;
        }
        else if(month == 2){
            if(isLeapYear(year)){
                return 29;
            }
            else{
                return 28;
            }
        }
        return 31;
    }

    static boolean isLeapYear(int year){
        if(year%400==0){
            return true;
        }
        else if(year%100!=0 && year%4==0){
            return true;
        }
        return false;
    }

    //Total Sundays in the 20th century..
    /*public static void main(String[] args){
        // Will count all sundays from 1 Jan, 1900 to 31 Dec, 2000 and then subtract the number of Sundays in the 1900 year.
        int extraDaysDueToLeapYear = getNumberOfLeapYears(1900, 2000);
        int totalSundaysFrom1900To2000 = (365*101 + extraDaysDueToLeapYear)/7;
        int totalSundaysIn1900 = 365/7;
        System.out.println(totalSundaysFrom1900To2000 - totalSundaysIn1900);
    }

    static int getNumberOfLeapYears(int start, int end){
        int count = 0;
        for(int i = start; i<=end; i++){
            if(i%400==0){
                count +=1;
            }
            else if(i%100!=0 && i%4==0){
                count +=1;
            }
        }
        return count;
    }*/
}
