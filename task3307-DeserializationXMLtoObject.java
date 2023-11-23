package com.codegym.task.task33.task3307;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.StringReader;

/* 
Deserializing an XML object

In the convertFromXmlToNormal method, the first parameter is a String containing an XML object.
The second parameter is the class of the object that must be returned.
The convertFromXmlToNormal method must create an object from the XML string and return it.

*/

public class Solution {
    public static void main(String[] args) throws IOException, JAXBException {
        String xmlData = "<cat><name>Missy</name><age>5</age><weight>4</weight></cat>";
        Cat cat = convertFromXmlToNormal(xmlData, Cat.class);
        System.out.println(cat);
    }

    public static <T> T convertFromXmlToNormal(String xmlData, Class<T> clazz) throws IOException, JAXBException {

        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xmlData);

        return (T) unmarshaller.unmarshal(reader);
    }

    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat {
        public String name;
        public int age;
        public int weight;

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", weight=" + weight +
                    '}';
        }
    }
}
