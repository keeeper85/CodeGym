package com.codegym.task.task28.task2805;

/* 
Thread priorities

In a separate file, create a class called MyThread that inherits Thread.
MyThread must:
1. Be able to be created using any of the superclass's constructors (Alt+Insert).
2. Thread priorities must be set using a loop—from the minimum to the maximum value.
3. If the thread has a thread group (ThreadGroup),
then the thread's priority can't be greater than its thread group's maximum priority.

*/

public class Solution {

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            System.out.print(new MyThread().getPriority() + " ");
        }
        // Output
        // 1 2 3 4 5 6 7 8 9 10 1 2

        System.out.println();
        ThreadGroup group = new ThreadGroup("someName");
        group.setMaxPriority(7);
        for (int i = 0; i < 12; i++) {
            System.out.print(new MyThread(group, "name" + i).getPriority() + " ");
        }
        // Output
        // 3 4 5 6 7 7 7 7 1 2 3 4

        System.out.println();
        ThreadGroup group1 = new ThreadGroup("someName");
        group1.setMaxPriority(7);
        for (int i = 0; i < 12; i++) {
            System.out.print(new MyThread(group1, "name" + i).getPriority() + " ");
        }
//    }
    }
}
