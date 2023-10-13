package com.codegym.task.task22.task2210;

/* 
StringTokenizer
Using a StringTokenizer, split the query into parts using the String delimiter.

For example: getTokens("level22.lesson13.task01", ".") returns a string array {"level22", "lesson13", "task01"}


Requirements:
1. The getTokens method must use a StringTokenizer.
2. The getTokens method must be public.
3. The getTokens method must have two String parameters.
4. The String array returned by the getTokens method must be filled correctly (according to the task conditions).

*/

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {

        String[] test = getTokens("level22.lesson13.task01", ".");

        for (int i = 0; i < test.length; i++){
            System.out.println(test[i]);
        }


    }
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> list = new ArrayList<>();


        while (stringTokenizer.hasMoreTokens()){
            list.add(stringTokenizer.nextToken());
        }

        return list.toArray(new String[0]);
    }
}
