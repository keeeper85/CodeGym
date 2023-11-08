package com.codegym.task.task28.task2807;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Introducing ThreadPoolExecutor

1. In the main method, create a LinkedBlockingQueue<Runnable> object.
2. Use a loop to add 10 Runnable tasks to the queue.
3. In each task's run method, call the doExpensiveOperation method using the task's sequence number,
starting from 1 (see the sample output).
4. Create a ThreadPoolExecutor object with the following arguments:
- 3 = the number of threads in the core pool,
- 5 = the maximum number of threads,
- 1000 = the time that additional threads should be kept alive after they finish running,
- milliseconds = the time unit, - the task queue created in step one.
5. Use the prestartAllCoreThreads method to start all the threads in the core thread pool.
6. Prevent new tasks from being added to the pool (shutdown method).
7. Give the ThreadPoolExecutor object 5 seconds to complete all of the tasks
(use the awaitTermination method with TimeUnit.SECONDS as an argument).

*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        // Add your code here

        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();
        final AtomicInteger counter = new AtomicInteger(1);

        for (int i = 0; i < 10; i++){
            blockingQueue.add(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(counter.getAndIncrement());
                }
            });
        }

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.MILLISECONDS, blockingQueue);

        threadPoolExecutor.prestartAllCoreThreads();

        threadPoolExecutor.shutdown();

        threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS);

        /* Example output
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
