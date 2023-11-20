package com.codegym.task.task31.task3106;

/* 
Unzipping a file

The main method accepts a list of arguments.
The first argument, resultFileName, is the name of the resulting file. The remaining arguments are the names of files for fileNamePart.
Each fileNamePart file is a part of a zip file. You need to unzip the entire file by assembling it from its parts.
Write the unzipped file to resultFileName.
Files inside the archive can be large, e.g. 50MB.
Files inside the archive can have any name.

Example input. The archive has one file named abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002

*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFile = args[0];
        List<String> zipFiles = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            String FilePath = args[i];
            zipFiles.add(FilePath);
        }
        Collections.sort(zipFiles);

        // put all inputstream into list
        List<FileInputStream> list = new ArrayList<>();
        for (String s : zipFiles)
            list.add(new FileInputStream(s));


        //read each inputstream using zipinputstream read and write using fileoutputstream
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(resultFile));
        ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(list)));

        for (ZipEntry entry = null; (entry = zipInputStream.getNextEntry()) != null; ) {
            byte[] buffer = new byte[1024];

            for (int readBytes = -1; (readBytes = zipInputStream.read(buffer, 0, buffer.length)) > -1; ) {
                outputStream.write(buffer, 0, readBytes);
            }
        }

        zipInputStream.close();
        outputStream.close();

    }
}
