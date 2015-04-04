package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 25/02/15.
 */
public class Prob15_LatticePaths {

        public static long binomialCoefficient(int n, int k)
        {
		/* N-choose-k combinatorics: (n! / (k! * (n-k)!)
		 * Where:
		 * 		n is the number of moves,
		 * 		k is the number of down and right moves required (20 each) */

            if (k > (n-k))
                k = n - k;

            long c = 1;

            for (int i = 0; i < k; i++)
            {
                c = c * (n-i);
                c = c / (i+1);
            }

            return c;
        }

        public static void main (String[] args)
        {
            long begin = System.currentTimeMillis();

            System.out.println(binomialCoefficient(40,20));

            long end = System.currentTimeMillis();
            System.out.println(end-begin + "ms");
        }
    //Correct solution.. but requires a huge space due to lot of recursions
    /*static long path = 0;
    public static void main(String[] args){
        tracePath(3,3);
        System.out.println(path);
    }

    static void tracePath(int i, int j){
        if(i == 0 && j==0){
            if(path == 0){
                path = 1;
            }
            else{
                path += 1;
            }
        }
        if(i!=0 && j==0){
            tracePath(--i, j);
        }
        if(i==0 && j!=0){
            tracePath(i, --j);
        }
        if(i!=0 && j!=0){
            tracePath(--i, j);
            tracePath(++i, --j);    // the i gets reduced at the previous step
        }
    }*/
}
