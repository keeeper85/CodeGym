package com.codegym.task.task30.task3002;

/* 
Mastering the methods of the Integer class

Use the Integer.parseInt(String, int) method to implement the convertToDecimalSystem method,
which should convert the passed string into a decimal number and return it as a string.

*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); // 22
        System.out.println(convertToDecimalSystem("012"));  // 10
        System.out.println(convertToDecimalSystem("0b10")); // 2
        System.out.println(convertToDecimalSystem("62"));   // 62
    }

    public static String convertToDecimalSystem(String s) {

        String number = s.substring(1);;

        if (s.startsWith("0x")){
            number = s.substring(2);
            return String.valueOf(Integer.parseInt(number, 16));
        }
        else if (s.startsWith("0b")){
            number = s.substring(2);
            return String.valueOf(Integer.parseInt(number, 2));
        }
        else if (!s.startsWith("0")){
            return String.valueOf(Integer.parseInt(s));
        }
        else return String.valueOf(Integer.parseInt(number, 8));

//        return "";
    }
}
