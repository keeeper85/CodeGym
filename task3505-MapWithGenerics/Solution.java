package com.codegym.task.task35.task3505;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* 
List to Map

Implement the ConvertibleUtil class's convert method. It must return a map whose values are the elements of the passed list, and whose keys are objects obtained by calling the getKey interface method.

The elements of the list must inherit Convertible, which in turn has some type parameter for a key.
For example, ConvertibleBook has a String type parameter. In other words, the resulting map's key must be a String
ConvertibleUser has an Integer type parameter. In other words, the resulting map's key must be an Integer

The values in the map must match the elements of the list.
See the main method for an example.

Arrange type parameters in the ConvertibleUtil.convert method.

*/

public class Solution {
    public static void main(String[] args) {
        List<ConvertibleUser> users = new ArrayList<>();
        users.add(new ConvertibleUser(234, "First User"));
        users.add(new ConvertibleUser(235, "Second User"));
        users.add(new ConvertibleUser(236, "Third User"));

        Map<Integer, ConvertibleUser> newMap = ConvertibleUtil.convert(users);
        System.out.println(newMap);
        // {236=ConvertibleUser{id=236, name='Third User'},
        // 235=ConvertibleUser{id=235, name='Second User'},
        // 234=ConvertibleUser{id=234, name='First User'}}

        //////////////////////////////////////////////////////////

        List<ConvertibleBook> books = new ArrayList<>();
        books.add(new ConvertibleBook("First Book"));
        books.add(new ConvertibleBook("Second Book"));
        books.add(new ConvertibleBook("Third Book"));

        Map<String, ConvertibleBook> bookMap = ConvertibleUtil.convert(books);
        System.out.println(bookMap);
        // {Third Book=ConvertibleBook{name='Third Book'},
        // First Book=ConvertibleBook{name='First Book'},
        // Second Book=ConvertibleBook{name='Second Book'}}
    }
}
