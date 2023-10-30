package com.codegym.task.task25.task2512;

/* 
Charting our own course
Implement the UncaughtExceptionHandler interface in the Solution class, which must:
1. Interrupt the thread that threw the exception.
2. Display the exception's stack trace, starting with the innermost exception.

new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))) Example output: java.lang.IllegalAccessException: GHI java.lang.RuntimeException: DEF java.lang.Exception: ABC


Requirements:
1. The Solution class must implement the Thread.UncaughtExceptionHandler interface.
2. After calling uncaughtException(), you must interrupt the thread that threw the exception.
3. Then display the exception stack trace, starting with the innermost exception.
4. Messages should be displayed in this format: "<exception class>: <exception message>".
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

//        String third = e.getCause().getCause().toString();
//        String second = e.getCause().toString();
//        String first = e.toString();
//
//        System.out.println(third);
//        System.out.println(second);
//        System.out.println(first);

        List<Throwable> stackTrace = new ArrayList<>();

        while (e != null){
            stackTrace.add(e);
            e = e.getCause();
        }

        Collections.reverse(stackTrace);

        stackTrace.forEach(System.out::println);


    }

    public static void main(String[] args) throws Exception {

        Solution s = new Solution();
        Thread.setDefaultUncaughtExceptionHandler(s);
        throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));

    }
}
