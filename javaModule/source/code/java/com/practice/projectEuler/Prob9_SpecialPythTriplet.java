package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 25/02/15.
 */
/*
if a + b +c =1000
then

 a + b + sqroot(a² + b²) = 1000

 -> (a² + b²) = (1000 -a -b)²

 -> a² + b² = 1000000 - 2000*(a+b) + a² + 2*a*b + b²

 -> 0 = 1000000 - 2000*(a+b) + 2*a*b

 -> ... (easy basic maths)

 -> a = (500000-1000*b) / (1000-b)
 b can't be higher than 499, because c>b and (b+c) would then be higher than 1000.
 */
public class Prob9_SpecialPythTriplet {
    public static void main(String[] args){
        System.out.print(getTheNumbersProduct(1000));
    }

    static int getTheNumbersProduct(double num){
        double a = 0;
        double otherNum = 0;
        for (int b = 1; b < num/3; b++){
            a = ((num*num/2) - (num*b))/(num-b);
            if(a%1 == 0){
                otherNum = b;
                break;
            }
        }
        double c = num-a-otherNum;
        System.out.println(a+ " " + otherNum + " " +  c);
        return (int)a * (int)otherNum * (int)c;
    }
}

