package com.codegym.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Find all the files

*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();

        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
                if (!Files.isDirectory(file)) result.add(file.toAbsolutePath().toString());
                return FileVisitResult.CONTINUE;
            }

        });


        return result;

    }

    public static void main(String[] args) throws IOException {

        String test = "C:\\Users\\raczk\\codegym\\11224209\\codegym-project\\src\\com\\codegym\\task";

        for (String s : getFileTree(test)) {
            System.out.println(s);
        }
    }
}
