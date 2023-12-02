package com.codegym.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Ancient Rome

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman numeral to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result: " + romanToInteger(romanString));
        System.lineSeparator();


//        bufferedReader.close();
    }

    public static int romanToInteger(String s) {
        /*
        I - 1
        V - 5
        X - 10
        L - 50
        C - 100
        D - 500
        M - 1000
         */

        if (s.length() < 1 || s == null || s.equals(null)) {
            System.out.println("This string is too short!");
            return 0;
        }

        if (s.length() > 15) {
            System.out.println("This string is too long!");
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toUpperCase().toCharArray();
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                System.out.println("This string contains invalid letters!");
                return 0;
            }
        }

        if (chars.length == 1) return map.get(chars[0]);

        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            int valueThis = map.get(chars[i]);
            if (i + 1 < chars.length){
                int valueNext = map.get(chars[i + 1]);
                if (valueThis < valueNext){
                    valueThis = valueNext - valueThis;
                    i++;
                }
            }
            result += valueThis; //0+5+1+1+1
        }

        return result;

    }
}
