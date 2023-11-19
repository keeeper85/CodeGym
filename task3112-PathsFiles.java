package com.codegym.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
File downloader

*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://venturebeat.com/wp-content/uploads/2015/12/oracle-java-e1450723340931.jpg", Paths.get("C:\\Users\\raczk\\codegym\\11224209\\codegym-project\\src\\com\\codegym\\task\\task31\\task3112"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // Implement this method

        URL url = new URL(urlString);

        String fileName = urlString.substring(urlString.lastIndexOf("/") + 1, urlString.lastIndexOf("."));
        String fileSuffix = urlString.substring(urlString.lastIndexOf("."));

        Path tempFile = Files.createTempFile(fileName, fileSuffix);
        Files.copy(url.openStream(), tempFile);

        return Files.move(tempFile, downloadDirectory.resolve(fileName + fileSuffix));

    }
}
