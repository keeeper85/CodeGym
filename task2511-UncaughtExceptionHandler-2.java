package com.codegym.task.task25.task2511;

import java.util.TimerTask;

/* 
Arming ourselves to the teeth!
Create your own UncaughtExceptionHandler as a local class inside the constructor.
The UncaughtExceptionHandler should hide the thread name with asterisks and display a description of the error that occurred.
"Thread-0" must be replaced with "********".
"Thread-4321" must be replaced with "***********".


Requirements:
1. Don't change the Solution class's definition or fields.
2. The Solution constructor must create its own UncaughtExceptionHandler, and store it in the handler field.
3. The created UncaughtExceptionHandler should display a description of the error that occurred.
4. In the error description, the thread name should be hidden by "*" characters.
*/

public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String message = e.getMessage();
                int nameLenght = t.getName().length();
                StringBuilder asterixes = new StringBuilder();

                for (int i = 0; i < nameLenght; i++){
                    asterixes.append("*");
                }

                message = message.replaceAll(t.getName(), asterixes.toString());

//                Thread.currentThread().setName(asterixes.toString());
//                t.setName(asterixes.toString());

                System.out.println(message);



            }
        };    // Init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
    }
}
