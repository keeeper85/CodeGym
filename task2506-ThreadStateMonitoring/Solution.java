package com.codegym.task.task25.task2506;

/* 
Monitoring thread state
Create a LoggingStateThread thread class, which will display all of the states (State) of the thread passed to the constructor.
The LoggingStateThread thread must terminate itself after the thread passed to the constructor has stopped.
The main() method is not tested.


Requirements:
1. Create a LoggingStateThread class in a separate file. It must inherit the Thread class.
2. The LoggingStateThread class must have a field for the thread it will monitor. This field must be initialized through the constructor.
3. Override the LoggingStateThread class's run() method.
4. After it starts running, the LoggingStateThread class should display changes to the passed thread's state.
5. After the monitored thread stops, the LoggingStateThread thread must also stop running.
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start(); // NEW
//        System.out.println(target.getState());
        Thread.sleep(100);
        target.start();  // RUNNABLE
//        System.out.println(target.getState());
        Thread.sleep(100);
        // TERMINATED
//        System.out.println(target.getState());
    }
}
