package com.codegym.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Read more about java.util.concurrent.locks.Lock at http://docs.oracle.com/ (Everything there is in Javadocs!)
Write the implementation of the someMethod() method:
1. try to acquire the lock
1.1. if the lock is busy, then call the actionIfLockIsBusy() method
1.2. if the lock is free, then: 1.2.1 call the actionIfLockIsFree() method
1.2.2 release the lock no matter what, even if actionIfLockIsFree() throws an exception
*/

public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        // Implement the logic here. Use the lock field

        boolean isLockAcquired = lock.tryLock();

        if (isLockAcquired){
            try{
                actionIfLockIsFree();
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        else actionIfLockIsBusy();

    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}
