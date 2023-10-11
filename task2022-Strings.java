package com.codegym.task.task22.task2202;

/* 
Find a substring
The getPartOfString method must return the substring that begins with the character after the first space and ends with the end of the word that follows the 4th space.
Example:
"CodeGym is the best place to learn Java."

Result:
"is the best place"

Example:
"Amigo and Diego are best friends!"

Result:
"and Diego are best"

If the input data is invalid, throw a StringTooShortException (create an exception).


Requirements:
1. The StringTooShortException class must be a child of the RuntimeException class.
2. The getPartOfString method must have a String parameter.
3. If invalid data is passed to the getPartOfString method, a StringTooShortException should be thrown.
4. The getPartOfString method must return the substring that begins with the character after the first space and ends with the word that follows the 4th space.

*/

public class Solution {
    public static void main(String[] args) throws StringTooShortException {
        System.out.println(getPartOfString("CodeGym is the best place to learn Java."));
    }

    public static String getPartOfString(String string) throws StringTooShortException {

        String[] array = null;
        String newString = "";

        try{
            array = string.split(" ");
        } catch (NullPointerException e){
            throw new StringTooShortException();
        }

        if (array.length <= 4){
            throw new StringTooShortException();
        }
        else {
            newString = array[1] + " " + array[2] + " " + array[3] + " " + array[4];
        }

        return newString;
    }

    public static class StringTooShortException extends RuntimeException {
    }
}
