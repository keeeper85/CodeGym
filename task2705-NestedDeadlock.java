package com.codegym.task.task27.task2705;

/* 
Another kind of deadlock

In the secondMethod method, arrange the synchronized blocks so that threads create deadlock when using the Solution class.

*/

public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            synchronized (this){
                doSomething();
            }

        }
    }

    private void doSomething() {
    }

    public static void main(String[] args) {



    }
}
