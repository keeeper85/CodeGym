package com.codegym.task.task31.task3111;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/* 
Advanced file search

Let's implement a configurable file search within a directory.
Look over the java.nio.file.FileVisitor interface and its superclass's implementation java.nio.file.SimpleFileVisitor.
When searching a file tree using the Files.walkFileTree(Path start, FileVisitor<? super Path> visitor) method,
we use the FileVisitor object to perform the required operations on the found Path objects.

Our search class will be called SearchFileVisitor and will extend SimpleFileVisitor.

You can search using the following criteria:
- a term found in the file name (String);
- a term found in the file's contents (String);
- a maximum or minimum file size (int).
You can specify several criteria at the same time.

I wrote code in main that uses the ready-to-use SearchFileVisitor to search for files. All you have to do is implement it. Simple!
Hint 1: The get... and set... methods are getters and setters. The search class's main logic is performed in the visitFile(Path file, BasicFileAttributes attrs) method.
Hint 2: Only use classes from the java.nio package to work with files.

*/

public class Solution {

    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

        searchFileVisitor.setPartOfName("amigo");
        searchFileVisitor.setPartOfContent("programmer");
        searchFileVisitor.setMinSize(5);
        searchFileVisitor.setMaxSize(10000);

//        Files.walkFileTree(Paths.get("D:/SecretFolder"), searchFileVisitor);
        Files.walkFileTree(Paths.get("C:\\Users\\raczk\\codegym\\11224209\\codegym-project\\src\\com\\codegym\\task"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }
}
