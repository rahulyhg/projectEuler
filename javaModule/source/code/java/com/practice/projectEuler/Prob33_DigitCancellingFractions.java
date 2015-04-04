package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 08/03/15.
 */
public class Prob33_DigitCancellingFractions {
    public static void main(String[] args){
        float[] num = new float[4];
        float[] den = new float[4];
        int index = 0;
        for(int i = 11; i<50; i++){
            if(i%10==0){
                continue;
            }
            for(float j = 1; i*j < 100; j++){
                for(float k = j+1; i*k < 100; k++){
                    if((int)(i*k)%10 == (int)(i*j)/10 && (k/j)==((int)((i*k)/10)/((i*j)%10))){
                        num[index] = j;
                        den[index] = k;
                        System.out.println(i*j + " " + i*k + " 1");
                        index++;
                    }
                    else if((int)(i*k)/10 == (int)(i*j)%10 && (k/j)==(((i*k)%10)/(int)((i*j)/10))){
                        num[index] = j;
                        den[index] = k;
                        index++;
                        System.out.println(i*j + " " + i*k + " 2");
                    }
                }
            }
        }
        int prodOfNume = 1;
        int prodOfDeno = 1;
        for(int i = 0; i<=3; i++){
            prodOfNume *= num[i];
            prodOfDeno *= den[i];
        }
        System.out.println(prodOfDeno/gcd(prodOfDeno, prodOfNume));
    }

    public static int gcd(int a, int b) {
        int y = 0;
        int x = 0;

        if (a > b) {
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }

        while (x % y != 0) {
            int temp = x;
            x = y;
            y = temp % x;
        }
        return y;
    }
}
