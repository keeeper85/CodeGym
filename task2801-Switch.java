package com.codegym.task.task28.task2801;

/* 
Mastering switch

Implement the switchTest method:
1. Don't use conditional operators.
2. Use 1 switch with 2 cases and 1 default.
3. Expected output:
Output for E1.A: "it's E1.A"
Output for E1.B: "it's E1.B"
Output for E1.C: "it's E1.C"
Output for E1.Y: "it's E1.Y"
Output for E2.D: "it's E2.D"
Output for E2.E: "it's E2.E"
Output for E2.F: "it's E2.F"
Output for all other values: "undefined".

*/

import static com.codegym.task.task28.task2801.Solution.E1.A;

public class Solution {
    public static enum E1 {A, B, C, Y}

    public static enum E2 {D, E, F}

    public static enum E3 {D, E, F}

    public static void main(String[] args) {
//        Solution.switchTest(E1.C);
//        Solution.switchTest(E3.D);
//        Solution.switchTest(E2.D);
        /* Output
        it's E1.C
        undefined
        it's E2.D
         */
        Solution.switchTest(E1.A);
        Solution.switchTest(E1.B);
        Solution.switchTest(E1.C);
        Solution.switchTest(E1.Y);
        Solution.switchTest(E2.D);
        Solution.switchTest(E2.E);
        Solution.switchTest(E2.F);
        Solution.switchTest(E3.D);
        Solution.switchTest(E3.E);
        Solution.switchTest(E3.F);
    }

    public static void switchTest(Enum obj) {
        // Add your code here
        String s = obj.getClass().getSimpleName();

        switch (s){

            case "E1":
                System.out.println("it's " + obj.getClass().getSimpleName() + "." + obj);
                break;
            case "E2":
                System.out.println("it's " + obj.getClass().getSimpleName() + "." + obj);
                break;

            default:
                System.out.println("undefined");
                break;
        }
    }
}
