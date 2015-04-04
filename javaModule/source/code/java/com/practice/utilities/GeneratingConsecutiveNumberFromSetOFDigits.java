package com.practice.utilities;

/**
 * Created by shruti.mantri on 13/03/15.
 */
public class GeneratingConsecutiveNumberFromSetOFDigits {
    public static void main(String[] args) {
        BruteForce();
    }

    static int[] perm = new int[] { 5, 6, 7, 8, 9 };

    public static void BruteForce() {
        int count = 1;
        int numPerm = 3265920;

        while (count < numPerm) {
            int N = perm.length;
            int i = N - 1;

            while (perm[i - 1] >= perm[i]) {
                i = i - 1;
            }

            int j = N;
            while (perm[j - 1] <= perm[i - 1]) {
                j = j - 1;
            }

            // swap values at position i-1 and j-1
            swap(i - 1, j - 1);

            i++;
            j = N;

            while (i < j) {
                swap(i - 1, j - 1);
                i++;
                j--;
            }
            count++;
        }
    }

    private static void swap(int i, int j) {
        int k = perm[i];
        perm[i] = perm[j];
        perm[j] = k;
    }

}
