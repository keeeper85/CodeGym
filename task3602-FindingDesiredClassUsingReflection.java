package com.codegym.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* 
Find the class by its description

Class description:
1. It implements the List interface;
2. It is a private static class inside a popular utility class;
3. Accessing the list by index is not allowed. It throws an IndexOutOfBoundsException.
Using reflection (getDeclaredClasses method), return the appropriate type in the getExpectedClass method.

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {

//        List<Object> list = Collections.
        Class clazz = Collections.class;
        for (Class clz : clazz.getDeclaredClasses()){
            if (Modifier.isPrivate(clz.getModifiers()))
                if (Modifier.isStatic(clz.getModifiers()))
                    if (List.class.isAssignableFrom(clz)){
                        try{
                            Constructor constructor = clz.getDeclaredConstructor();
                            constructor.setAccessible(true);
                            List list = (List)constructor.newInstance();
                            System.out.println(list.get(0));
                        } catch (IndexOutOfBoundsException e){
                            return clz;
                        } catch (Exception ignored){

                        }
                    }
        }


        return null;
    }
}
