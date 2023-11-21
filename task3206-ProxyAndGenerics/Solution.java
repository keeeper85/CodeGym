package com.codegym.task.task32.task3206;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/* 
Generics for creating a proxy object

Create a public getProxy() method in the Solution class:
1) The getProxy() method must return a proxy for any interface that inherits Item.
2) The getProxy() method must have two parameters. The first is the class of the return value, and the second is additional interface classes (use a variable-length argument ...).
3) Use ItemInvocationHandler to create a proxy.
The main() method is not tested.

*/

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        // true false false
        test(solution.getProxy(Item.class, Small.class));           // true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));// true true true
        test(solution.getProxy(Big.class, Small.class));            // true true true, because Big inherits Item
        test(solution.getProxy(Big.class));                         // true true false, because Big inherits Item
    }

    public <T extends Item>T getProxy(Class<T> first, Class<?>... second) {

        List<Class> list = new ArrayList<>();

        for (Class c: second) {
            list.add(c);
        }
//        if (first.getName().equals("com.codegym.task.task32.task3206.Item")) {
//            list.add(Item.class);
//        } else if (first.getName().equals("com.codegym.task.task32.task3206.Big")) {
//            list.add(Big.class);
//        }
        list.add(first);

        Class[] allInterfaces = list.toArray(new Class[0]);
        ClassLoader classLoader = this.getClass().getClassLoader();

        return (T) (Proxy.newProxyInstance(classLoader, allInterfaces, new ItemInvocationHandler()));
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}
