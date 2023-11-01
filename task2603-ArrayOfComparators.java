package com.codegym.task.task26.task2603;

/* 
A convert can easily convert others

*/

import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {

        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T> ...comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {

            int i = 0;

            for (Comparator<T> comparator : comparators){
                i = comparator.compare(o1, o2);
                if (i != 0){
                    return i;
                }

            }
            return i;
        }


    }
}
