package com.codegym.task.task31.task3101;

/* 
Iterating through a file tree
1. The main method is passed two arguments as inputs.
The first argument is path, which is the path to the directory; the second is resultFileAbsolutePath, which is
the name (full path) of an existing file that will store the result.

2. For each file in the path directory and in all of its subdirectories, do the following:
For each file whose size in bytes is NOT greater than 50, do the following:
2.1. Sort them by file name in ascending order. Don't include the path when sorting.
2.2. Rename resultFileAbsolutePath to "allFilesContent.txt" (use the FileUtils.renameFile method and
 FileUtils.isExist if necessary).
2.3. Sequentially write the contents of each file from step 2.1 to allFilesContent.txt. After the body of each file, write "\n".
All files have the TXT extension.
Use "/" as the path separator.

1. The file passed as the second argument to main must be renamed to allFilesContent.txt.
2. You need to create a stream to write to the renamed file.
3. The contents of every file that is 50 bytes or smaller must be sorted by file name and written to the allFilesContent.txt file.
4. The output stream to the file must be closed.
5. Don't use static variables.
//C:\\Users\\tygrusia\\Desktop\\paths"
//"C:\\Users\\tygrusia\\Desktop\\resultFileAbsolutePath.txt"

*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        //String path = args[0];
        File dir = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);


        // File dir = new File("C:\\Users\\tygrusia\\Desktop\\paths");
        // File resultFileAbsolutePath = new File("C:\\Users\\tygrusia\\Desktop\\resultFileAbsolutePath.txt");

        try {
            //path to the be renamed file
            //result.renameTo(new File("allFilesContent.txt"));
            File destination = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");




            if (FileUtils.isExist(destination)) {
                FileUtils.deleteFile(destination);
            }
            //rename the resultFileAbsolutePath to allFilesContent.txt
            FileUtils.renameFile(resultFileAbsolutePath, destination);
            TreeMap<String, byte[]> tree = new TreeMap<>(String::compareTo);
            generateTree(dir, tree);

            //write the contents of TreeMap into the  allFilesContent.txt file
            try (FileOutputStream fileOutputStream = new FileOutputStream(destination)) {
                for (byte[] bytes : tree.values()) {
                    fileOutputStream.write(bytes);
                    fileOutputStream.write("\n".getBytes());
                }
            }
        }catch (IOException ignored) { }


    }
    //check which files are smaller and equal to 50(in bytes) and write their contents to the TreeMap
    public static void generateTree (File root, TreeMap map){
        Arrays.stream(Objects.requireNonNull(root.listFiles())).forEach(file -> {
            if(file.isDirectory()){generateTree(file, map);}
            else if(file.length()<51){
                try{map.put(file.getName(),Files.readAllBytes(Paths.get(file.getPath())));}
                catch(IOException ignored){}
            }
        });
    }
}



