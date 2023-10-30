package com.codegym.task.task25.task2509;

import java.util.concurrent.*;

/* 
It's not as easy as it seems
1. Read online about Socket, ThreadPoolExecutor, RunnableFuture, and Callable.
2. Implement the logic of the SocketTask class's cancel() method.
3. Implement the cancel() method's logic for a local class inside the SocketTask class's newTask method.


Requirements:
1. Don't change the SocketTask class definition (its fields or method signatures).
2. The SocketTask class's cancel() method must close the resources used by the class.
3. The cancel() method for the local class inside the newTask method must close the SocketTask resources and call the parent class's cancel() method.
4. The parent class's method must be called even if an exception is thrown while closing resources.
*/

public class Solution extends ThreadPoolExecutor {
    public Solution(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        } else {
            return super.newTaskFor(callable);
        }
    }

    public static void main(String[] args) {
    }
}
