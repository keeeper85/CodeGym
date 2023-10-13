package com.codegym.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* 
Changing the encoding
The first parameter of the main method is the name of a file encoded in Windows-1251.
The second parameter of the main method is the name of a file to which you need to write the contents of the first file, but encoded in UTF-8.


Requirements:
1. The program must not read data from the keyboard.
2. The program should not display data on the screen.
3. The program must write data to a file.
4. The contents of the second file must match the contents of the first file except for the encoding (UTF-8).

*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String inputFile = args[0];
        String outputFile = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputFile)));

        Charset win = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");

        while (reader.ready()){
            String temp = reader.readLine();
            byte[] buffer = temp.getBytes(win);
            String s = new String(buffer, utf);
            writer.write(s);
        }

        reader.close();
        writer.close();



    }
}
