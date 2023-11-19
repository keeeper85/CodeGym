package com.codegym.task.task31.task3104;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Search for hidden files

In the Solution class, override the logic of the following two methods:
visitFile - in addition to the existing logic, add all paths to ZIP and RAR files to the archived field
visitFileFailed - add all paths to inaccessible files to the failed field and return SKIP_SUBTREE
Example output: D:/mydir/BCD.zip
The main method is not tested

*/

public class Solution extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Solution solution = new Solution();
        Files.walkFileTree(Paths.get("D:/"), options, 20, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException{
        String fileName = file.getFileName().toString().toLowerCase();
        if (fileName.endsWith(".zip") || fileName.endsWith(".rar")) archived.add(file.toAbsolutePath().toString());

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exception) throws IOException {
        failed.add(file.toAbsolutePath().toString());
        return FileVisitResult.SKIP_SUBTREE;
    }

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }
}
