package com.codegym.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //This method must return the number of values in our collection.
        int count = 0;

        for (Entry<K, List<V>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty() && entry.getValue() != null){
                for (V value : entry.getValue()) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public V put(K key, V value) {
        //This must add value using key.
        // If key is already in the map and the number of values for key is less than repeatCount,
        // then add value to the end of the list in the map object.
        // If the number of values stored using key equals repeatCount,
        // then remove the element with index zero from the map object's list and add value to the end of the list.
        // The method must return the value of the last item added using key (but not the value we're currently adding).
        // If key doesn't have any values yet, then return null. ???

//        if (!map.containsKey(key)) return null;

        List<V> values;
        if (map.get(key) == null){
            values = new ArrayList<>();
            map.put(key, values);
        }
        values = map.get(key);
        int valuesCount = values.size();

        if (valuesCount < repeatCount && valuesCount > 0) {
            V valueToReturn = values.get(valuesCount -1);
            values.add(value);
            return valueToReturn;
        }
        else if (valuesCount == 0){
//            V valueToReturn = value;
            values.add(value);
            return null;
        }
        else {
            V valueToReturn = values.get(repeatCount -1);
            values.remove(0);
            values.add(value);
            return valueToReturn;
        }

    }

    @Override
    public V remove(Object key) {
        //This method must remove a value using key.
        // If several elements are stored using key, then the element with the index zero must be removed from the list.
        // If an empty list is stored for key, then remove the key-value pair.
        // The method must return the element that you removed. If the key isn't in the map, return null.

        if (!map.containsKey(key)) return null;
//
        List<V> values = map.get(key);
        if (values.isEmpty()) map.remove(key);
        V valueToReturn = values.get(0);
        values.remove(0);
        if (values.isEmpty()) map.remove(key);

        return valueToReturn;
    }

    @Override
    public Set<K> keySet() {
        //This method must return a set with all of the keys in map.

        Set<K> result = new HashSet<>();
        for (K entry : map.keySet()) {
            result.add(entry);
        }

        return result;
    }

    @Override
    public Collection<V> values() {
        //This method must return an ArrayList<V> with all of the values. The order of the values in the list isn't important.

        ArrayList values = new ArrayList<>();

        for (Entry<K, List<V>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty() && entry.getValue() != null){
                for (V value : entry.getValue()) {
                    values.add(value);
                }
            }
        }

        return values;
    }

    @Override
    public boolean containsKey(Object key) {
        //This method must return true if key is in map, otherwise it must return false.

        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //this must return true if value is in map, otherwise it must return false.



        for (Entry<K, List<V>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty() && entry.getValue() != null){
                for (V items : entry.getValue()) {
                    if (items.equals(value)) return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}