package com.codegym.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Adding a file to an archive

Add the fileName file to the archive inside the "new" directory.
If the archive already has a file with the same name in the "new" directory, then replace it.

Example input:
C:/result.mp3
C:/pathToTest/test.zip

Files inside test.zip:
a.txt
b.txt

After running Solution.main, the test.zip archive must contain the following:
new/result.mp3
a.txt
b.txt

Hint: you need to first save the contents of all of the zip entries somewhere,
and then write all the entities together with the added file to the archive.
Don't use the file system.

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // Get arguments
        String fileName = args[0];
        String zipFilePath = args[1];
        String onlyFileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);

        // Copy zip entries to a zip entry list
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath));

        ZipEntry ze;
        Map<String, byte[]> zipMap = new HashMap<>();
        while ((ze = zis.getNextEntry()) != null) {
            int len;
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = zis.read(buffer)) > 0) {
                baos.write(buffer, 0, len);
            }
            zipMap.put(ze.getName(), baos.toByteArray());
            baos.close();
        }
        // close zip input stream
        zis.close();

        // Open Zip Output Stream
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath));

        // 3. You need to write the contents of the file passed to main as the first argument to the ZipOutputStream.
        zos.putNextEntry(new ZipEntry("new/" + onlyFileName));
        Files.copy(Paths.get(fileName), zos);

        // 4. You need to write all of the other content read from the ZipInputStream to the ZipOutputStream.
        for(Map.Entry<String, byte[]> entry : zipMap.entrySet()){
            String name = entry.getKey();
            if (!(name.equals("new/" + Paths.get(fileName).getFileName().toString()))) {
                byte[] bytes = entry.getValue();
                ZipEntry zipEntry = new ZipEntry(name);
                zipEntry.setSize(bytes.length);
                zos.putNextEntry(zipEntry);
                zos.write(bytes);
            }
        }

        // close zip output stream
        zos.close();

    }
}
