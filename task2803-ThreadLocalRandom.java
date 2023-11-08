package com.codegym.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom

The Solution class will be used by threads.
Implement all of the methods using the ThreadLocalRandom class.
getRandomIntegerBetweenNumbers must return a random int between "from" and "to".
getRandomDouble must return a random double.
getRandomLongBetween0AndN must return a random long between 0 and n.

*/

public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {

        return ThreadLocalRandom.current().nextInt(from, to);
    }

    public static double getRandomDouble() {

        return ThreadLocalRandom.current().nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {

        return ThreadLocalRandom.current().nextLong(n);
    }

    public static void main(String[] args) {

        System.out.println(getRandomIntegerBetweenNumbers(0,10));
        System.out.println(getRandomDouble());
        System.out.println(getRandomLongBetween0AndN(100));

    }
}
