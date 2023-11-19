package com.codegym.task.task31.task3111;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // File size: content.length

        Map<String, Boolean> activeParameters = new HashMap<>();
        TreeSet<Path> foundFilesTree = new TreeSet<>();

        if (partOfName != null) activeParameters.put("partOfName", true);
        else activeParameters.put("partOfName", false);
        if (partOfContent != null) activeParameters.put("partOfContent", true);
        else activeParameters.put("partOfContent", false);
        if (minSize != 0) activeParameters.put("minSize", true);
        else activeParameters.put("minSize", false);
        if (maxSize != 0) activeParameters.put("maxSize", true);
        else activeParameters.put("maxSize", false);

        for (Map.Entry<String, Boolean> params : activeParameters.entrySet()) {
            if (params.getValue() == true){
                if (params.getKey() == "partOfName"){
                    if (file.getFileName().toString().contains(partOfName)) foundFilesTree.add(file);
                }
            }
            if (params.getValue() == true){
                if (params.getKey() == "partOfContent"){
                    String contentOfTheFile = new String(content, StandardCharsets.UTF_8);
                    if (contentOfTheFile.contains(partOfContent)) foundFilesTree.add(file);
                }
            }
            if (params.getValue() == true){
                if (params.getKey() == "minSize"){
                    if (content.length >= minSize) foundFilesTree.add(file);
                }
            }
            if (params.getValue() == true){
                if (params.getKey() == "maxSize"){
                    if (content.length <= maxSize) foundFilesTree.add(file);
                }
            }
        }
        List<Path> toRemove = new ArrayList<>();

        for (Path foundFile : foundFilesTree) {
            if (activeParameters.get("partOfName") == true){
                if (!foundFile.getFileName().toString().contains(partOfName)) toRemove.add(foundFile);
            }
            if (activeParameters.get("partOfContent") == true){
                String contentOfTheFile = new String(content, StandardCharsets.UTF_8);
                if (!contentOfTheFile.contains(partOfContent)) toRemove.add(foundFile);
            }
            if (activeParameters.get("minSize") == true){
                if (content.length < minSize) toRemove.add(foundFile);
            }
            if (activeParameters.get("maxSize") == true){
                if (content.length > maxSize) toRemove.add(foundFile);
            }
        }

        for (Path path : toRemove) {
            if (foundFilesTree.contains(path)) foundFilesTree.remove(path);
        }

        for (Path foundFile : foundFilesTree) {
            foundFiles.add(foundFile);
        }

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String amigo) {
        this.partOfName = amigo;
    }

    public void setPartOfContent(String programmer) {
        this.partOfContent = programmer;
    }

    public void setMinSize(int i) {
        this.minSize = i;
    }

    public void setMaxSize(int i) {
        this.maxSize = i;
    }

    public List<Path> getFoundFiles() {
        return this.foundFiles;
    }
}
