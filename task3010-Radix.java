package com.codegym.task.task30.task3010;

/* 
Smallest possible radix

The main method's first argument is a string that contains a sequence of characters (All characters in the string have ASCII codes (32 to 127 inclusive)). The string length does not exceed 255 characters. You need to implement a program that determines whether the content of the string is a number written in a number system whose base does not exceed 36. If it is, then you need to display the smallest valid radix for this number. If it is not, then you need to display "Invalid".
Number systems whose base is greater than 10 use Latin letters as numerals. For example, the number 35 in the decimal system corresponds to the number "Z" in the system with a base of 36. Since we are considering positional notation, the minimum base that the program should display is 2.
If any exceptions occur, catch them and do not display the stack trace.

Example 1:
Input:

00
Expected output:
2
Example 2:
Input:
12AS08z
Expected output:
36
Example 3:
Input:
12AS08Z/
Expected output:
Invalid

*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //write your code here

        try{
            String ourNumber = args[0];
            System.out.println(getSmallestRadix(ourNumber));
        } catch (Exception e){

        }



    }
    public static String getSmallestRadix(String test)
    {
        for(int i = 2; i <= 36; i++)
        {
            try
            {
                BigInteger bigInteger = new BigInteger(test, i);
                return "" + i;
            }
            catch (Exception e)
            {

            }
        }
        return "Invalid";
    }
}