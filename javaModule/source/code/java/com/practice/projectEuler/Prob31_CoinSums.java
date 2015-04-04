package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 27/02/15.
 */
public class Prob31_CoinSums {
    //Dynamic Programming Solution
    //http://www.mathblog.dk/project-euler-31-combinations-english-currency-denominations/
    public static void main(String[] args){
        int target = 200;
        int[] coinSizes = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] ways = new int[201];
        ways[0] = 1;
        for(int i=0; i<coinSizes.length; i++){
            for(int j=coinSizes[i]; j<ways.length; j++){
                ways[j] += ways[j-coinSizes[i]];
            }
        }
        System.out.println(ways[200]);
    }
   //Brute force approach
   /* public static void main(String[] args){
        int target  = 20;
        int ways = 0;

        for (int a = target; a >= 0; a -= 200) {
            for (int b = a; b >= 0; b -= 100) {
                for (int c = b; c >= 0; c -= 50) {
                    for (int d = c; d >= 0; d -= 20) {
                        for (int e = d; e >= 0; e -= 10) {
                            for (int f = e; f >= 0; f -= 5) {
                                for (int g = f; g >= 0; g -= 2) {
                                    ways++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.print(ways);
    }*/
}
