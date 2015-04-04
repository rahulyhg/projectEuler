package com.practice;

/**
 * Created by shruti.mantri on 11/02/15.
 */

/*qaz is a value for a number where this number is less than the other next values which have indexes larger than the index of this number.
  for example: 33 , 25 , 26 , 58 , 41 , 59 -> qaz of (33) = 3 where 33 less than 3 numbers (58 , 41 , 59), qaz of (25) = 4 and not 5 because the index of 33 is less than the index of 25, qaz of (26) = 3 , qaz of (58) = 1 , qaz of (41) = 1 , qaz of (59) = 0.
  the question is to find the max qaz.
  it can be solved simply using 2 loops which takes time of O(n^2).
  that's ok but how can we solve this problem in O(nlogn).

This solution takes O(nlogn)*/

public class QAZValue {

    public static void main(String[] args) {
        //int[] array = {7, 8, 2, 3, 4, 5 };
        int[] array = {25, 3, 33, 26, 15, 16, 17, 18, 41, 59, 4};
        //int[] array = { 33, 25, 26, 58, 41, 59};
        System.out.println(getMaxQAZ(array));
    }

    public static int getMaxQAZ(int[] array){
        if (array == null) {
            return 0;
        }
        return getMaxQAZ(array, 0, array.length-1).qaz;
    }

    private static QAZResult getMaxQAZ(int[] array, int start, int end) {
        if (end <= start) {
            return new QAZResult(array[end], 0);
        }

        if (end == start+1) {
            if (array[start] < array[end]) {
                return new QAZResult(array[start], 1);
            }

            return new QAZResult(array[end], 0);
        }

        int middle = (end + start) / 2;

        QAZResult leftResult = getMaxQAZ(array, start, middle);

        QAZResult rightResult = getMaxQAZ(array, middle+1, end);

        /*if (leftResult.minVal < rightResult.minVal) {
            return new QAZResult(leftResult.minVal, leftResult.qaz + end - middle);
        }*/

        for (int i = middle+1; i <= end; i++) {
            if (leftResult.minVal < array[i]) {
                leftResult.qaz++;
            }
        }

        return leftResult.qaz > rightResult.qaz ? leftResult : rightResult;
    }
}

class QAZResult {
    int minVal;
    int qaz;

    public QAZResult(int minVal, int qaz) {
        this.minVal = minVal;
        this.qaz = qaz;
    }
}