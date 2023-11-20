package com.codegym.task.task31.task3109;

import java.io.*;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Reading config files

Implement the getProperties method, which must read the properties from the passed fileName file.
fileName can have any extension, e.g. XML, any other extension, or none at all.
You need to ensure the properties are read properly. If errors occur, a null object must be returned.
The main method is not tested.
Hint: you may need File.separator.

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        Properties properties;
        Properties properties = solution.getProperties("4.JavaCollections/src/com/codegym/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/codegym/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/codegym/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {

        File file = new File(fileName);

        Properties properties = new Properties();
        try {
            if (fileName.endsWith(".xml")) properties.loadFromXML(new FileInputStream(file));
            else properties.load(new FileReader(file));
        } catch (IOException e) {
            return new Properties();
        }


        return properties;
    }
}
