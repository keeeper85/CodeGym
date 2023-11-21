package com.codegym.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/* 
Password generator

Implement the getPassword() method, which must return a ByteArrayOutputStream with the bytes comprising the password. 
Password requirements: 
1) 8 characters. 
2) Only numbers and uppercase and lowercase Latin letters. 
3) At least one numeral, one lowercase letter, and one uppercase letter. 
All generated passwords must be unique.
Example of a valid password: wMh7smNu

*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(i + " " + password.toString());
        }
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        List<Character> numerals = new ArrayList<>();
        List<Character> lowercase = new ArrayList<>();
        List<Character> uppercase = new ArrayList<>();

        for (int i = 48; i < 58; i++) {
            numerals.add((char) i);
        }

        for (int i = 97; i < 123; i++) {
            lowercase.add((char) i);
        }

        for (int i = 65; i < 91; i++) {
            uppercase.add((char) i);
        }

        boolean hasNumeral = false;
        boolean hasLowercase = false;
        boolean hasUppercase = false;

        StringBuilder stringBuilder;

        while (true){
            stringBuilder = new StringBuilder("");
            for (int i = 0; i < 8; i++) {
                int randomArray = ThreadLocalRandom.current().nextInt(0,3);
                switch (randomArray){
                    case 0:
                        int randomNumeral = ThreadLocalRandom.current().nextInt(0,10);
                        stringBuilder.append(numerals.get(randomNumeral));
                        break;
                    case 1:
                        int randomLowercase = ThreadLocalRandom.current().nextInt(0,26);
                        stringBuilder.append(lowercase.get(randomLowercase));
                        break;
                    case 2:
                        int randomUppercase = ThreadLocalRandom.current().nextInt(0,26);
                        stringBuilder.append(uppercase.get(randomUppercase));
                        break;
                }
            }

            String password = stringBuilder.toString();
            char[] passCharacters = password.toCharArray();

            for (int i = 0; i < passCharacters.length; i++) {
                if (numerals.contains(passCharacters[i])) hasNumeral = true;
                if (lowercase.contains(passCharacters[i])) hasLowercase = true;
                if (uppercase.contains(passCharacters[i])) hasUppercase = true;
            }

            if (hasNumeral){
                if (hasLowercase && hasNumeral){
                    if (hasUppercase && hasLowercase && hasNumeral){
                        break;
                    }
                }
            }
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] password = stringBuilder.toString().getBytes();

        for (int i = 0; i < password.length; i++) {
            byteArrayOutputStream.write(password[i]);
        }
        
        return byteArrayOutputStream;
    }
}
