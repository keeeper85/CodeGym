package com.codegym.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/* 
Deserializing a JSON object

In the convertFromJsonToNormal method, the first parameter is the name of a file that contains one JSON object.
The second parameter is the name of the class of the object serialized in the file.
The convertFromJsonToNormal method should extract the object from the file, convert it from JSON, and return it.
Use the readValue method with (File, Class) or (Reader, Class) parameters.

*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new File(fileName), clazz);
    }

    public static void main(String[] args) {

    }
}
