package com.codegym.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Using TreeSet

The first parameter is the file name: file1.
file1 only contains Latin letters, spaces, punctuation, dashes, and carriage returns.
Sort the letters alphabetically and display the first 5 unique letters on a single line without separators.
If there are less than 5 unique letters in file1, then display them all.
Uppercase and lowercase letters should be treated as the same letter.
The displayed result is not case sensitive.
Close the streams.

Example 1 - input file data:
zBk yaz b-kN

Example 1 - output:
abkny

Example 2 - input file data:
caAC
A, aB? bB

Example 2 - output:
abc

Hint: use TreeSet

*/

public class Solution {
    public static void main(String[] args) throws IOException {

//        file1 only contains Latin letters, spaces, punctuation, dashes, and carriage returns.

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        StringBuilder stringBuilder = new StringBuilder();

        while (fileReader.ready()){
            stringBuilder.append(fileReader.readLine());
        }


        String filename = stringBuilder.toString();
        TreeSet<Character> set = new TreeSet<>();
        char[] chars = filename.toLowerCase().toCharArray();

        for (char aChar : chars) {
            if (aChar > 96 && aChar <= 122) set.add(aChar);
        }

        int count = 0;
        int maxCount;

        if (chars.length >= 5) maxCount = 5;
        else maxCount = chars.length;

        for (Character c : set) {
            if (count >= maxCount) break;
            System.out.print(c);
            count++;
        }



    }
}
