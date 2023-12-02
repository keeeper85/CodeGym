package com.codegym.task.task37.task3701;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* 
Circular iterator

The Solution class inherits ArrayList.
Properly override the  iterator method in the Solution class.
Write your own CircularIterator class inside the Solution class.
It will be an iterator for the Solution list.
The iterator must move circularly through all of the elements.
In all other ways, its behavior must be identical to the current iterator.

*/

public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);


        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator(){
        return new CircularIterator();
    }

    public class CircularIterator implements Iterator<T> {

        Iterator<T> iterator = Solution.super.iterator();
        int count = 0;

        @Override
        public boolean hasNext() {
            if (size() == 0)
                return false;

            if (count >= size()) {
                iterator = Solution.super.iterator();
                count = 0;
            }

            return true;
        }

        @Override
        public T next() {
            count++;
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            iterator.forEachRemaining(action);
        }


    }

}
