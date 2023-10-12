package com.codegym.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Inverted words
In the main method, read the name of a file that contains words separated by spaces from the console.
In the text of the file, find all pairs of words that are mirror images of each other. Add them to result.
Use StringBuilder.
The file encoding is UTF-8.

Example of file contents

rat tar tart a
a tot tot tot
Output:
rat tar
a a
tot tot

Requirements:
1. The main method must read the filename from the keyboard.
2. The main method must use StringBuilder.
3. The Solution class must contain a nested Pair class with equals, hashCode, and toString methods. Don't delete or change these methods.
4. The Pair class must declare a constructor without parameters, i.e. a default constructor.
5. The result list must be filled with correct pairs according to the task conditions.

*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        List<String> words = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
        while (fileReader.ready()) {
            words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }
        fileReader.close();

        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); ) {
                if (i >= words.size()) {
                    break;
                }
                if (words.get(j).equals(new StringBuilder(words.get(i)).reverse().toString()) && j != i) {
                    Pair pair = new Pair();
                    pair.first = words.get(j);
                    pair.second = words.get(i);
                    result.add(pair);
                    words.remove(j);
                    words.remove(i);
                    j = 0;
                } else
                    j++;
            }
        }

        for (Pair values : result){
            System.out.println(values);
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }

}
