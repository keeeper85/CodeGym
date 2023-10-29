package com.codegym.task.task25.task2505;

/* 
No idiots
1. Create a private MyUncaughtExceptionHandler class that waits half a second when catching an exception, and then display the secretKey, thread name, and exception message.
Use String.format(...).

Example:
super secret key, Thread-0, This is an example

2. Analyze the sequence of executable code and be sure to log the exception from item 1.

3. The main() method is not tested.


Requirements:
1. Create a private MyUncaughtExceptionHandler class with a default constructor in the MyThread class.
2. When catching an exception, MyUncaughtExceptionHandler should call Thread.sleep(500).
3. Then MyUncaughtExceptionHandler should display the secretKey, thread name, and exception message on the console.
4. Use String.format(...) to display the message.
5. You need to ensure that the exception is logged.
*/

public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(false);
        }

        @Override
        public void run() {
            throw new NullPointerException("This is an example");
        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

            @Override
            public void uncaughtException(Thread t, Throwable e) {


                try {
                    Thread.sleep(500);
                    String message = String.format("%s, %s, %s", secretKey, t.getName(), e.getLocalizedMessage());
                    System.out.println(message);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }


            }
        }
    }

}

