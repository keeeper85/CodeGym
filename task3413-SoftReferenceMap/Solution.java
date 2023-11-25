package com.codegym.task.task34.task3413;

/* 
Cache based on SoftReference

Implement the SoftCache class's get, put, and remove methods:

The AnyObject get(Long key) method must return an AnyObject from cacheMap using key. If key isn't in cacheMap, then return null.

The AnyObject put(Long key, AnyObject value) method must add a key-value pair to the map. The method must return null if cacheMap isn't already storing a value using key. Otherwise, it must return the value already stored using key. Don't forget to call the clear() method on the SoftReference<AnyObject> object.

The AnyObject class's remove(Long key) method must remove from cacheMap the key-value pair that matches key. The method must return null if cacheMap isn't already storing a value using key. Otherwise, it must return the value already stored using key. Don't forget to call the clear() method on the SoftReference<AnyObject> object.

Don't change the AnyObject class.
The main method is not tested.

*/

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        for (long i = 0; i < 2_500_000; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }
    }
}