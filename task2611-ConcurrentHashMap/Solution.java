package com.codegym.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
The world doesn't change, we change

Analyze ConcurrentHashMap.
In a separate file, create a Producer class that will: 1. every half second,
add a key and value to a ConcurrentHashMap, where the key is the counter starting from 1,
and the value is a phrase like "Some text for i",
e.g. "Some text for 1". 2. when an exception occurs, display the following: "[THREAD_NAME] thread was terminated",
e.g. "[thread-1] thread was terminated".

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        Producer producer = new Producer(map);
        Consumer consumer = new Consumer(map);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(2000);

        executorService.shutdownNow();
        // Finally, 5 lines have to be printed
    }
}
