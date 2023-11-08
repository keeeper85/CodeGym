package com.codegym.task.task28.task2806;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Introducing Executors

1. In the main method, create a fixed pool of 5 threads using the Executors class.
2. Use a loop to send 10 Runnable tasks to the pool.
3. In each task's run method, call the doExpensiveOperation method using the task's sequence number,
starting from 1 (see the sample output).
4. Prevent new tasks from being added to the pool (shutdown method).
5. Give the pool 5 seconds to complete all of the tasks
(use the awaitTermination method with TimeUnit.SECONDS as an argument).

*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        // Add your code here

        ExecutorService executor = Executors.newFixedThreadPool(5);
        final AtomicInteger sequence = new AtomicInteger(1);

        for (int i = 0; i < 10; i++){
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(sequence.getAndIncrement());
                }
            };
            executor.submit(task);
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        /* Example output
pool-1-thread-2, localId=2
pool-1-thread-1, localId=1
pool-1-thread-3, localId=3
pool-1-thread-1, localId=7
pool-1-thread-1, localId=9
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
pool-1-thread-2, localId=6
pool-1-thread-1, localId=10
pool-1-thread-3, localId=8
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
