package com.codegym.task.task36.task3610;

import java.util.Map;

/* 
MyMultiMap

Amigo, sometimes Java's built-in collections aren't enough. When that's the case, you can use third-party implementations, such as Google Guava or Apache Commons, or you can implement your own data structure. Today you have a unique opportunity to put your knowledge to the test and write part of your own data structure.

Our data structure is called MyMultiMap. It is a generic class, inherits HashMap, and implements the Cloneable and Serializable interfaces. Our map will be special in that its constructor will accept an int repeatCount argument, which is the number of values that a single key can store.

Implement the following methods:
1) int size() - This method must return the number of values in our collection.
2) V put(K key, V value) - This must add value using key. If key is already in the map and the number of values for key is less than repeatCount, then add value to the end of the list in the map object. If the number of values stored using key equals repeatCount, then remove the element with index zero from the map object's list and add value to the end of the list. The method must return the value of the last item added using key (but not the value we're currently adding). If key doesn't have any values yet, then return null.
3) V remove(Object key) - This method must remove a value using key. If several elements are stored using key, then the element with the index zero must be removed from the list. If an empty list is stored for key, then remove the key-value pair. The method must return the element that you removed. If the key isn't in the map, return null.
4) Set<K> keySet() - This method must return a set with all of the keys in map.
5) Collection<V> values() - This method must return an ArrayList<V> with all of the values. The order of the values in the list isn't important.
6) boolean containsKey(Object key) - This method must return true if key is in map, otherwise it must return false.
7) boolean containsValue(Object value) - this must return true if value is in map, otherwise it must return false.

See the example in the main() method.
The main() method is not tested.

*/

public class Solution {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new MyMultiMap<>(3);
//        System.out.println(map.size());
        for (int i = 0; i < 7; i++) {
            map.put(i, i);
        }
        map.put(5, 56);
        map.put(5, 57);
        System.out.println(map.put(5, 58));             // Expected: 57

        System.out.println(map);                        // Expected: {0=0, 1=1, 2=2, 3=3, 4=4, 5=56, 57, 58, 6=6}
        System.out.println(map.size());                 // Expected: size = 9

        System.out.println(map.remove(5));              // Expected: 56
        System.out.println(map);                        // Expected: {0=0, 1=1, 2=2, 3=3, 4=4, 5=57, 58, 6=6}
        System.out.println(map.size());                 // Expected: size = 8

        System.out.println(map.keySet());               // Expected: [0, 1, 2, 3, 4, 5, 6]
        System.out.println(map.values());               // Expected: [0, 1, 2, 3, 4, 57, 58, 6]

        System.out.println(map.containsKey(5));         // Expected: true
        System.out.println(map.containsValue(57));      // Expected: true
        System.out.println(map.containsValue(7));       // Expected: false
    }
}