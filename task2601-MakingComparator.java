package com.codegym.task.task26.task2601;

/* 
Read online about the median of a sample

*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        //find median
        int median = 0;
        if (array.length%2 == 0) median = (array[array.length/2 - 1] + array[array.length/2])/2;
        else median = array[array.length/2];
        final int MEDIAN = median;

        //create Comparator
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1-MEDIAN) - Math.abs(o2 - MEDIAN) ;
            }
        };

        Arrays.sort(array, comparator);


        return array;

    }
}
