package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shruti.mantri on 11/02/15.
 */
public class FreeCalendar {

    public static void main(String[] args){
        List<Interval> person1 = new ArrayList<Interval>();
        List<Interval> person2 = new ArrayList<Interval>();
        person1.add(new Interval(1,5));
        person1.add(new Interval(10,14));
        person1.add(new Interval(19,20));
        person1.add(new Interval(21,24));
        person1.add(new Interval(27,30));
        person2.add(new Interval(3,5));
        person2.add(new Interval(12,15));
        person2.add(new Interval(18,21));
        person2.add(new Interval(23,24));
        findFreeIntervals(person1, person2);
    }

    static void findFreeIntervals(List<Interval> person1, List<Interval> person2){
        int i =0, j = 0;
        int intervalStart = 1, intervalEnd;
        while(i < person1.size() && j < person2.size()){
            if(intervalStart == 1 && intervalStart < person1.get(i).start && intervalStart < person2.get(j).start){
                intervalEnd = Math.min(person1.get(i).start, person2.get(j).start) -1 ;
                System.out.println(intervalStart+","+intervalEnd);
            }
            if(person1.get(i).end <= person2.get(j).start){

            }
        }
    }

    static class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
