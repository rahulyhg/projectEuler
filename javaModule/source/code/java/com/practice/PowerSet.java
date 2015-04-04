package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti.mantri on 10/03/15.
 */
//Iterative Version
public class PowerSet {
    public static void main(String[] args){
        List<Integer> input = new ArrayList();
        input.add(1);
        input.add(2);
        input.add(3);
        getSubSets(input);
    }

    static List<List<Integer>> getSubSets(List<Integer> n){
        List<List<Integer>> output = new ArrayList();
        List<Integer> temp = new ArrayList();
        output.add(temp);

        for(int i=0; i<n.size(); i++){
            int outputSize = output.size();
            for(int j = 0; j<outputSize; j++){
                temp = new ArrayList();
                temp.addAll(output.get(j));
                temp.add(n.get(i));
                output.add(temp);
            }
        }
        return output;
    }
}
