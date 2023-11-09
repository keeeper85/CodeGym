package com.codegym.task.task28.task2811;

/* 
ReentrantReadWriteLock

The ReadWriteMap class must correctly provide access to a Map object across multiple threads,
but mistakes were made during implementation. Find them and fix them.
P.S. For Map to operate properly in a multithreaded environment,
it's preferable to use a standard implementation, such as ConcurrentHashMap from the java.util.concurrent package.
But sometimes you need to work with another type of Map, for example,
a LinkedHashMap, and then the proposed solution would be perfect.

*/

import java.util.LinkedHashMap;

public class Solution {
    public static void main(String[] args) {
        ReadWriteMap<Integer, String> linkedSafeMap = new ReadWriteMap<>(new LinkedHashMap<>());
    }
}
