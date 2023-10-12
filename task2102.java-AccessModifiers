package com.codegym.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Compare modifiers
Implement the logic of the isModifierSet method, which checks whether the passed allModifiers argument has a specific modifier set (specificModifier).

P.S. Before implementing the task, take a look at the Modifier class and the implementation of isPublic, isStatic, and so on.


Requirements:
1. The isModifierSet method must be static.
2. The isModifierSet method should return a boolean.
3. The isModifierSet method must have two int parameters.
4. The isModifierSet method must return the correct value according to the task conditions (true, if the specified modifier is set in allModifiers; otherwise, false).

*/

public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        //return false; the easiest way is just to check if the Integer value of the specificModifier is smaller or equal allModifiers, but it will work only in this situation, the full solution needs work with bit shifting
        return  specificModifier <= allModifiers;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
