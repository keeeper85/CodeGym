package com.codegym.task.task34.task3401;

/* 
Fibonacci numbers using recursion

Read about Fibonacci numbers. (1, 1, 2, 3, 5, 8, 13, 21, 34...)
Implement a recursive fibonacci method, where n is the number of an element in the Fibonacci sequence.
Don't create additional fields in the Solution class.

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.fibonacci(9));     // 34
        System.out.println(solution.fibonacci(5));     // 5
        System.out.println(solution.fibonacci(2));     // 1
        System.out.println(solution.fibonacci(1));     // 1
    }

    public int fibonacci(int n) {

        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);

    }
}
