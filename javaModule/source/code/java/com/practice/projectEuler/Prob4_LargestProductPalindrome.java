package com.practice.projectEuler;

/**
 * Created by shruti.mantri on 25/02/15.
 */

//O(n^2)
// Used num/2 as the limit of the loop;
public class Prob4_LargestProductPalindrome {
    public static void main(String[] args)
    {
        long biggest = 0;

        int a = 999, b = 999;
        for (int bb = b; bb > 500; bb--)
        {
            for (int aa = a; aa > 500; aa--)
            {
                if ( isPalindrome(new Long(aa * bb).toString()) )
                {
                    if ( aa*bb > biggest )
                    {
                        biggest = aa*bb;
                    }
                }
            }
        }

        System.out.println(biggest);
    }

    static boolean isPalindrome( String s )
    {
        //if odd length then remove middle character
        if ( s.length() % 2 != 0 )
        {
            s = s.substring( 0, s.length() / 2 ) + s.substring( (s.length() / 2) + 1);
        }

        return new StringBuffer( s.substring( 0, s.length() / 2) ).
                reverse().toString().equals( s.substring( s.length() / 2) );
    }
}
