package com.codegym.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Reading from a stream

Implement the getAllDataFromInputStream() method. It must return a StringWriter containing all of the data from the passed stream.
Under no circumstances should null be returned.
The main() method is not tested.

*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\Users\\raczk\\codegym\\11224209\\codegym-project\\src\\com\\codegym\\task\\task32\\task3202\\testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) {

        StringWriter writer = new StringWriter();

        if (is != null){
            try{
                while (is.available() > 0){
                    writer.write(is.read());
                }
                return writer;
            } catch (Exception ignored){

            }
        }

        return writer;
    }
}
