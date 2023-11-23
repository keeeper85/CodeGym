package com.codegym.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.DataInput;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Using JSON to convert from one class to another

Two classes have the same fields, but they don't have a common superclass. Example, First and Second classes.
Implement the convertOneToAnother method, which should return an instance of the resultClassObject class, whose fields are equal to the fields in the one object.
Use an ObjectMapper object.
Everybody knows that classes have a JSON annotation where the property equals the class's name in lowercase letters.
For example, for the First class, its className="first"
The First and Second classes themselves are not tested — they are provided as test data.

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.disable(MapperFeature.USE_ANNOTATIONS).convertValue(one, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int i;
        public String name;
    }
}
