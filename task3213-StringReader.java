package com.codegym.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/* 
Caesar cipher

Hi, Amigo. You know we're being followed. They're looking through our mail. So we need to encrypt our traffic.
Implementing a Caesar cipher won't be hard for you.
Let me remind you that this is simply a right-shift along the alphabet by the number of letters
indicated by the key parameter. The main() method has a good example.
Implement the String decode(StringReader reader, int key) method. The method receives encoded data.
It must return the decrypted string stored in the StringReader. Under no circumstances should null be returned.
The main() method is not tested.

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  // Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        if (reader != null){
            while (true) {
                int currentCharacter = reader.read();
                if (currentCharacter == -1) break;
                char character = (char) (currentCharacter + key);
                stringBuilder.append(character);
            }
            return stringBuilder.toString();
        }

        return stringBuilder.toString();
    }
}
