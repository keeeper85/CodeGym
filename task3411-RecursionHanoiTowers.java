package com.codegym.task.task34.task3411;

/* 
Tower of Hanoi

There are three rods. There are numRings rings stacked on rod A. Each ring has a different size and they're stacked from smallest to largest (largest on the bottom). You need to move the pyramid of numRings rings from rod A to rod B in as few moves as possible.
You can only move one ring at a time, and you can't put a larger ring on top of a smaller one.
You need to implement a public static void moveRing(char a, char b, char c, int numRings) method, which displays the sequence of actions needed to move the rings from rod A to rod B.

Method parameters:
char a - the name of the rod that all of the rings start on;
char b - the name of the rod that all of the rings must be moved to;
char c - the name of the third rod;
int numRings - the total number of rings that must be moved.
The task must be solved using a recursive call to the moveRing method.

Example 1:
The moveRing method is called using the following arguments: 'A', 'B', 'C', 1

Expected output:
from A to B

Example 2:
The moveRing method is called using the following arguments: 'A', 'B', 'C', 3

Expected output:
from A to B
from A to C
from B to C
from A to B
from C to A
from C to B
from A to B

Hint: The total number of actions is equal to 2^count - 1.

*/

public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        if (numRings > 1) {
            moveRing(a, c, b, numRings - 1);
            System.out.println("from " + a + " to " + b);
            moveRing(c, b, a, numRings - 1);
        } else {
            System.out.println("from " + a + " to " + b);
        }
    }
}