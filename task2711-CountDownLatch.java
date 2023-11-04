package com.codegym.task.task27.task2711;

import java.util.concurrent.CountDownLatch;

/* 
CountDownLatch

You are given a standard implementation of the wait-notify pattern.
Read about CountDownLatch and use the latch field to rewrite the body of the someMethod method.
Remove all unnecessary code from the class.

*/

public class Solution {
//    private final Object lock = new Object();
    private volatile boolean isWaitingForValue = true;

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {

        latch.await();
        retrieveValue();
        latch.countDown();


//        synchronized (lock) {
//            while (isWaitingForValue) {
//                lock.wait();
//            }
//
//            retrieveValue();
//
//            isWaitingForValue = false;
//            lock.notify();
//        }
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) throws InterruptedException {

        Solution solution = new Solution();
        solution.someMethod();

    }
}
