package com.codegym.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Using RandomAccessFile

The main() method accepts three arguments:
1) fileName - the path to a file;
2) number - a position in the file;
3) text - the text.

Read text from the file, starting from the position indicated by number. The length is the same as the length of the text passed as the third argument.
If the read text is the same as the passed text, then write "true" at the end of the file, otherwise write "false".
Use RandomAccessFile and its seek(long pos), read(byte[] b, int off, int len), and write(byte[] b) methods.
Use one of the String class's constructors to convert the read string into text.

*/

public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            long number = Long.parseLong(args[1]);
            String text = args[2];
            long fileLength = raf.length();

            raf.seek(number);
            byte readBytes[] = new byte[text.length()];
            raf.read(readBytes, 0, text.length());

            String readString = new String(readBytes);

            raf.seek(fileLength);
            if (readString.equals(text)) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}