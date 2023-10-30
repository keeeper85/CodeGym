package com.codegym.task.task25.task2508;

/* 
No goofing off
Restore the logic of the TaskManipulator class.


Requirements:
1. The TaskManipulator class must implement the Runnable and CustomThreadManipulator interfaces.
2. The run() method must display the name of the running thread every 100 milliseconds.
3. The TaskManipulator class must have an internal Thread field.
4. The start() method must create, internally store, and run a thread with the name passed to the method as an argument.
5. The stop() method must interrupt the last thread created by the TaskManipulator class.
*/

public class Solution
{
    /*
     Output:
     first
     first
     second
     second
     second
     third
     fifth
     */
    public static void main(String[] args) throws InterruptedException {
        CustomThreadManipulator manipulator = new TaskManipulator();

        manipulator.start("first");
//        System.out.println(Thread.currentThread().getName());
        Thread.sleep(150);
        manipulator.stop();

        manipulator.start("second");
//        System.out.println(Thread.currentThread().getName());
        Thread.sleep(250);
        manipulator.stop();

        manipulator.start("third");
        Thread.sleep(50);
        manipulator.stop();

        manipulator.start("forth");
        manipulator.stop();

        manipulator.start("fifth");
        Thread.sleep(1);
        manipulator.stop();
    }
}
