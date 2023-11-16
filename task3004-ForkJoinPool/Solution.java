package com.codegym.task.task30.task3004;

import java.util.concurrent.ForkJoinPool;

/* 
Fork/Join

1. Create a BinaryRepresentationTask class.
To do this, click Alt+Enter -> Create Class... on the red class name in IntelliJ IDEA. (The class must inherit RecursiveTask<String>).
The constructor's parameter is int x.
2. Implement the compute method: the number should be converted to binary.
3. Use the fork and join methods. 4. An example implementation is the convertToBinaryRepresentation method.

*/

public class Solution {
    private String convertToBinaryRepresentation(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return convertToBinaryRepresentation(b) + result;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String result1 = solution.convertToBinaryRepresentation(6);
        System.out.println(result1);

        System.out.println();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String result2 = forkJoinPool.invoke(new BinaryRepresentationTask(6));
        System.out.println(result2);
    }

}
