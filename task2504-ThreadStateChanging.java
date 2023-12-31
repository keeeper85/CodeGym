package com.codegym.task.task25.task2504;

/* 
A switch for threads
Process the list of threads depending on their state:
1. If the thread isn't running yet, then start it.
2. If the thread is waiting, then interrupt it.
3. If the thread is running, check the isInterrupted flag.
4. If the thread has stopped running, then display its priority on the console.
Use a switch statement.


Requirements:
1. The processThreads() method take an array of threads as an argument.
2. If the passed thread is not running, you need to start it.
3. If the passed thread is waiting, you need to interrupt it.
4. If the passed thread is running, then you need to check the isInterrupted flag.
5. If the passed thread has finished running, you need to display its priority on the console.
6. The processThreads() method must use a switch statement.
*/

import javax.swing.plaf.nimbus.State;

public class Solution {
    public static void processThreads(Thread... threads) {
        // Implement this method
        Thread[] array = threads;
        Thread.State threadState;

        for (int i = 0; i < array.length; i++){
            threadState = array[i].getState();
            switch (threadState){
                case NEW :
                    array[i].start();
                    break;
                case TIMED_WAITING:
                    array[i].interrupt();
                    break;
                case WAITING:
                    array[i].interrupt();
                    break;
                case BLOCKED:
                    array[i].interrupt();
                    break;
                case RUNNABLE:
                    array[i].isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(array[i].getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
