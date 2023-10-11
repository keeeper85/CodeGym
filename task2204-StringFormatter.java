package com.codegym.task.task22.task2204;

import java.util.Locale;

/* 
Correct the getFormattedString method so that it returns a string with format specifiers.
Don't use \n to convert carriage returns.

The output should be:
20 / 7 = 2.86
Exp = 3.33e+00


Requirements:
1. The expression '\n' should not be used to convert the string.
2. The getStringFormat method must be static.
3. The screen output must match the task conditions.
4. The getStringFormat method must return a string with format specifiers in accordance with the task conditions.

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(Locale.ENGLISH, getStringFormat(), 20.0 / 7.0, 10.0 / 3.0));
        // The output should be
        // 20 / 7 = 2.86
        // Exp = 3.33e+00
    }

    public static String getStringFormat() {
        //return "20 / 7 = % %Exp = %";

        return "20 / 7 = %.2f%nExp = %.2e";
    }
}
