package com.codegym.task.task32.task3203;

/* 
Writing a stack trace

Implement the getStackTrace() method, which must return the passed exception's entire stack trace as one string
(a single String object). Use an appropriate method from the Throwable class.
It will help you write the stack trace to a StringWriter. The main() method is not tested.

*/

import java.io.PrintWriter;
import java.io.StringWriter;

public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {

        StackTraceElement[] elements = throwable.getStackTrace();
        StringWriter writer = new StringWriter();

        throwable.printStackTrace(new PrintWriter(writer));

//        for (int i = 0; i < elements.length; i++) {
//            writer.write(elements[i].toString());
//        }

        return writer.toString();
    }
}
