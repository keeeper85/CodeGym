package com.codegym.task.task30.task3012;

/* 
Derive a specific number

Implement the createExpression(int number) method.
The createExpression method has one parameter called number. This parameter is a number from 1 to 3000 inclusive.
You need to display an arithmetic expression whose result is number.
You can use the numbers 1, 3, 9, 27, 81, 243, 729, and 2187 no more than once.
You can use "+" and "-" signs any number of times.
Please note that a plus or minus sign must precede each number in the resulting string.
Before the expression, display "<passed number> =". (See the examples of output below).

Example 1:
Passed number:

74
Expected output:
74 = - 1 + 3 - 9 + 81

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //write your code here
        String output = balancedTernary(number);

        System.out.print(number + " =");

        for (int i = output.length()-1; i >= 0; i--) {
            char ch = output.charAt(i);
//
            if (ch == 'Z') {
                System.out.print(" - " + (int)Math.pow(3, output.length()-i-1));
            }
            else if (ch == '1') {
                System.out.print(" + " + (int)Math.pow(3, output.length()-i-1));
            }
        }
    }

    public static String balancedTernary(int n)
    {
        String output = "";
        while (n > 0)
        {
            int rem = n % 3;
            n = n / 3;
            if (rem == 2)
            {
                rem = -1;
                n++;
            }
            output = (rem == 0 ? '0' :
                    (rem == 1) ? '1' : 'Z') + output;
        }
        return output;
    }
}