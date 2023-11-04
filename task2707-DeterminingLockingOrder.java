package com.codegym.task.task27.task2707;

/* 
Determining locking order

1. The objective is to check if the arguments are passed this way:
someMethodWithSynchronizedBlocks(Object obj1, Object obj2)
OR this way:
someMethodWithSynchronizedBlocks(Object obj2, Object obj1)
which will affect locking them by future threads. Changing the values above will also help us test our solution before validation.

2. To check the sequence we need to create 2 threads:
Thread thread1 = new Thread(new Runnable()... will lock o1 for 100ms.
Thread thread2 = new Thread(new Runnable()... will start 10ms after thread1 so at the time o1 is still locked.

3. If thread 2 want to lock o1 at first (so according to the parameters o1 and then o2) will have to wait 90ms more. In that time thread1 will lock o2 (and unlock the moment after it increments our Integer[] check variable). Check has now value 1:
return check[0] != 0 ? true : false;
which returns true - arguments are passed according to the given pattern.

4. On the other hand, if we try to pass:
someMethodWithSynchronizedBlocks(Object obj2, Object obj1)
thread1 will lock o1 for 100ms but thread2 (10ms after) doesn't care about this - it needs and locks o2 which is free at the moment. Now thread2 needs o1 which is still locked so it waits.
Meanwhile 100ms waiting has passed and thread1 wants to lock o2:
synchronized (o2){
                       check[0]++;
                   }
But it can't - it's locked by thread2! We have a deadlock in which check[0]++ never happens! Now we have a failsafe:
Thread.sleep(100);
which stops treads and let the method return:
return check[0] != 0 ? true : false;
false, as check hasn't gotten incremented.

After Thread.sleep(100) program comes back to life and needs to be stopped manually (deadlock is still on!).

*/

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {

            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        final Integer[] check = {0};

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("exception");
                    }
                    synchronized (o2){
                        check[0]++;
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o2, o1);
            }
        });

        thread1.start();
        Thread.sleep(10);
        thread2.start();
        Thread.sleep(100);

        return check[0] != 0 ? true : false;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
