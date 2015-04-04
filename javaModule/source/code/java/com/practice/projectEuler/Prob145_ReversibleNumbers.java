package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 27/02/15.
 */
//Awesom Explanation : http://www.mathblog.dk/project-euler-145-how-many-reversible-numbers-are-there-below-one-billion/

public class Prob145_ReversibleNumbers {
    public static void main(String[] args){
        int count = 0;
        for (int i = 1; i < 10; i++) {
            switch (i % 4) {
                case 0:
                case 2:
                    count += 20 * (int) Math.pow(30, (i / 2 - 1));
                    break;
                case 3:
                    count += 100 * (int)Math.pow(500, i / 4);
                    break;
                case 1:
                    break;
            }
        }
        System.out.println(count);
    }
}
