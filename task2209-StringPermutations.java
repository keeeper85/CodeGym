package com.codegym.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
Make a word chain
In the main method, read the name of a file that contains words separated by spaces from the console.
In the getLine method, use StringBuilder to order all the words as follows: the last letter of a word must match the first letter of the next word (ignore case).
Each word should be used once.
The getLine method can return any variant.
Separate words with a space.
Display the resulting string on the screen.

Example input file:

Okinawa Washington Auckland Kalamazoo Norfolk
Result:
Washington Norfolk Kalamazoo Okinawa Auckland

Requirements:
1. The main method must read the filename from the keyboard.
2. There should not be static fields in the Solution class.
3. The getLine method must use StringBuilder.
4. The getLine method must return an empty string (an empty StringBuilder) if it is not passed arguments (words).
5. The getLine method must not change the arguments (words).
6. All words passed to the getLine method must be included in the resulting string, if possible.
7. The screen output must match the task conditions.

*/

public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {
            while (fileReader.ready()) {
                list.add(fileReader.readLine());
            }
        } catch (IOException ignored) {
        }

        List<String> resultList = new ArrayList<>();
        for (String line : list) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                resultList.add(tokenizer.nextToken());
            }
        }

        StringBuilder result = getLine(getWords(resultList));
        System.out.println(result.toString());
    }

    private static String[] getWords(List<String> list) {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private static boolean isTheSameChars(String firstWord, String secondWord) {
        if (firstWord.endsWith(" ")) {
            firstWord = firstWord.substring(0, firstWord.length() - 1);
        }
        return firstWord.isEmpty() || (secondWord != null &&
                Character.toUpperCase(firstWord.charAt(firstWord.length() - 1)) == Character.toUpperCase(secondWord.charAt(0)));
    }

    private static <T> T getLastElement(List<? extends T> list) {
        return list.get(list.size() - 1);
    }


    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(i);
            if (findSolutions(list, words)) {
                for (Integer integer : list) {
                    builder.append(words[integer]);
                    builder.append(" ");
                }
                return builder;
            }
            list.remove(Integer.valueOf(i));
        }

        return builder;
    }

    public static boolean findSolutions(List<Integer> list, String... words) {
        if (list.size() == words.length) {
            return true;
        }
        for (int i = 0; i < words.length; i++) {
            if (isValid(list, words[i], words)) {
                list.add(i);
                if (findSolutions(list, words)) {
                    return true;
                }
                list.remove(Integer.valueOf(i));
            }
        }
        return false;
    }

    static boolean isValid(List<Integer> list, String word, String... words) {
        for (Integer integer : list) {
            if (words[integer].equals(word)) {
                return false;
            }
        }
        return isTheSameChars(words[getLastElement(list)], word);
    }

}
