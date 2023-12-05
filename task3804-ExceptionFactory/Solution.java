package com.codegym.task.task38.task3804;

/* 
Exception factory

Create an exception factory class that has a single static method that returns the required exception.
This method should accept one enum argument.
Do the following for each of these enums:
* ApplicationExceptionMessage: return an Exception
* DatabaseExceptionMessage: return a RuntimeException
* UserExceptionMessage: return an Error otherwise: return IllegalArgumentException without a message.

Use the name of the enum field as the message of the returned object, replacing all of the underscores with spaces. Everything must be lowercase except the first character of the message.
For example, the message for ApplicationExceptionMessage.SOCKET_IS_CLOSED should be "Socket is closed".

Return the created factory class in the Solution.getFactoryClass method.

Don't change the enums.

*/

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {

        ExceptionFactory.getException(ApplicationExceptionMessage.SOCKET_IS_CLOSED);

    }
}