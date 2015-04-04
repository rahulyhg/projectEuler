package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 08/03/15.
 */
public class Prob26_LongestRecurringCycle {
    public static void main(String[] args){
        int sequenceLength = 0;
        int number = 0;
        for (int i = 1000; i > 1; i--) {
            if (sequenceLength >= i) {
                break;
            }

            int[] foundRemainders = new int[i];
            int value = 1;
            int position = 0;

            while (foundRemainders[value] == 0 && value != 0) {
                foundRemainders[value] = position;
                value *= 10;
                value %= i;
                position++;
            }

            if (position - foundRemainders[value] > sequenceLength) {
                sequenceLength = position - foundRemainders[value];
                number = i;
            }
        }
        System.out.println(number + " " + sequenceLength);
    }
}
