package com.codegym.task.task21.task2103;

/*
Everything ingenious is simple!
Simplify. Don't rename variables. Don't leave comments.


Requirements:
1. The calculate method must be static.
2. The calculate method should return a boolean.
3. The calculate method must have four boolean parameters.
4. The calculate method should be as simple as possible (without changing the behavior).

*/

public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    }


    public static void main(String[] args) {
        System.out.println(calculate(true, true, false, false));


    }
}
