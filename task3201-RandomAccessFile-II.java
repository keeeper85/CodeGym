package com.codegym.task.task32.task3201;

/* 
Writing to an existing file

he main() method accepts three arguments:
1) fileName - the path to a file;
2) number - a position in the file;
3) text - the text.
Write text to the fileName file starting at the position indicated by number.
The write operation must overwrite the old data in the file.
If the file is too short, then begin writing at the end of the file.
Use RandomAccessFile and its seek() and write() methods.

*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {

//        String fileName = "C:\\Users\\raczk\\codegym\\11224209\\codegym-project\\src\\com\\codegym\\task\\task32\\task3201\\test.txt";
//        long position = 0;
//        String text = "new content new content new content new content new content new content";

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");){
            long textLength = args[2].length();
            long fileLength = randomAccessFile.length();

            if (textLength + Long.parseLong(args[1]) > fileLength) randomAccessFile.seek(fileLength);
            else randomAccessFile.seek(Long.parseLong(args[1]));

            randomAccessFile.write(args[2].getBytes());
        } catch (IOException ignored){
            ignored.getStackTrace();
        }
    }
}
