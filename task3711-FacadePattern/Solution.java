package com.codegym.task.task37.task3711;

/* 
Facade

The Facade pattern lets you hide a system's complexity by consolidating every possible external call into a single object,
and then delegating them to the appropriate objects within the system.
In this case, separate CPU, Memory, and HardDrive objects are created in the Solution class and methods
are subsequently called on these objects. It would be much more convenient for the client
(in this case, the Solution class) if there was a Computer class that encapsulated the creation of the objects
and provided a single point for interacting with them.

Let's do some refactoring:
1) Create a Computer class. Create and initialize CPU, Memory and HardDrive fields in it.
2) In the Computer class, implement a void run() method that calls all of the required methods on the CPU, Memory, and HardDrive objects.
3) Delete the contents of the Solution class's main method and instead create and run a new computer there.

*/

public class Solution {
    public static void main(String[] args) {
//        CPU cpu = new CPU();
//        Memory memory = new Memory();
//        HardDrive hardDrive = new HardDrive();
//
//        cpu.calculate();
//        memory.allocate();
//        hardDrive.storeData();

        Computer computer = new Computer();
        computer.run();

    }
}
