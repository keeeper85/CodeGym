package com.codegym.task.task31.task3107;

/* 
Null object pattern

Read about the null-object pattern on Wikipedia.
Use Files to correctly initialize the fileData field with a ConcreteFileData object in the Solution class's constructor.
If you have any problems reading the file in the pathToFile path, then initialize the field with a NullFileData object.

*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {

        Path file = Paths.get(pathToFile);

        try {
            fileData = new ConcreteFileData(Files.isHidden(file), Files.isExecutable(file), Files.isDirectory(file), Files.isWritable(file));
        } catch (Exception e) {
            fileData = new NullFileData(e);
//            fileData = new ConcreteFileData(nullFileData.isHidden(), nullFileData.isExecutable(), nullFileData.isDirectory(), nullFileData.isWritable());
        }

    }

    public FileData getFileData() {
        return fileData;
    }
}
