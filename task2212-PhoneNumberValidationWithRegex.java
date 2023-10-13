package com.codegym.task.task22.task2212;

/* 
Phone number verification
The checkPhoneNumber method should check whether the phoneNumber argument is a valid phone number.

Verification criteria:
1) if the number starts with '+', then it must contain 12 digits
2) if the number starts with a digit or opening parenthesis, then it must contain 10 digits
3) the number may contain 0-2 non-consecutive '-' characters
4) the number may contain 1 pair of matching parentheses, which must be to the left of the '-' characters
5) the parentheses must contain exactly 3 digits
6) the number cannot contain letters
7) the number must end with a digit

Here are some examples:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050xxx4567 - false
050123456 - false
(0)501234567 - false

Requirements:
1. The checkPhoneNumber method should return a boolean.
2. The checkPhoneNumber method must be public.
3. The checkPhoneNumber method must have one String parameter.
4. The checkPhoneNumber method must correctly check the validity of the phone number passed as an argument.

*/

import java.nio.charset.Charset;
import java.text.ParseException;

public class Solution {
    public static boolean checkPhoneNumber(String phoneNumber) {

        Solution solution = new Solution();

        if (phoneNumber == null || phoneNumber.equals("")) return false;

//        6) the number cannot contain letters
        if (phoneNumber.replaceAll("\\P{Alpha}", "").length() > 0) return false;

//        7) the number must end with a digit
        if (!(solution.isDigit(phoneNumber.charAt(phoneNumber.length() - 1)))) return false;

//        5) the parentheses must contain exactly 3 digits
        int firstParenthesis = phoneNumber.indexOf("(");
        int lastParenthesis = phoneNumber.indexOf(")");

        if ((solution.charFrequency('(', phoneNumber) > 0) && (lastParenthesis - firstParenthesis) != 4) return false;


//        1) if the number starts with '+', then it must contain 12 digits
        if ((phoneNumber.startsWith("+")) && (phoneNumber.replaceAll("\\D", "").length() != 12)) return false;


//        2) if the number starts with a digit or opening parenthesis, then it must contain 10 digits
        if ((solution.isDigit(phoneNumber.charAt(0)) || phoneNumber.charAt(0) == '(') && phoneNumber.replaceAll("\\D", "").length() != 10) return false;

//        3) the number may contain 0-2 non-consecutive '-' characters
        String[] dashes = phoneNumber.split("-");
        if ((dashes.length > 3) || ((dashes.length == 3) && (dashes[1].equals("")))) return false;

//        4) the number may contain 1 pair of matching parentheses, which must be to the left of the '-' characters
        if (solution.charFrequency('(', phoneNumber) != solution.charFrequency(')', phoneNumber)) return false;

        int firstDashIndex = phoneNumber.indexOf('-');
        int firstOpenParIndex = phoneNumber.indexOf('(');
        int firstCloseParIndex = phoneNumber.indexOf(')');

        if (firstOpenParIndex > firstCloseParIndex) return false;

        if (solution.charFrequency('-',phoneNumber) >= 1 && ((firstOpenParIndex > firstDashIndex) || (firstCloseParIndex > firstDashIndex))) return false;






        return true;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String phoneNumber = "(0)501234567";
        System.out.println(checkPhoneNumber(phoneNumber));


    }

    public boolean isDigit(char letter){
        try {
            int i = Integer.parseInt(String.valueOf(letter));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public int charFrequency(char letter, String number){
        char[] characters = number.toCharArray();
        int count = 0;

        for (int i = 0; i < characters.length; i++){
            if (letter == characters[i]) count++;
        }


        return count;
    }
}
