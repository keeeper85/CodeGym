package com.codegym.task.task22.task2208;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Build a WHERE query
Build part of a WHERE query using StringBuilder.
If a parameter is null, then it shouldn't be included in the query.

Example:

{name=Johnson, country=United States, city=Los Angeles, age=null}
Result:
name = 'Johnson' and country = 'United States' and city = 'Los Angeles'

Requirements:
1. The getQuery method must have one Map parameter.
2. The getQuery method must return a String.
3. The getQuery method must be static.
4. The getQuery method must return a string built according to the rules specified in the task conditions.

*/

public class Solution {
    public static void main(String[] args) {

        Map<String, String> test = new HashMap<>();

//        test.put("name", "Johnson");
//        test.put("country", "United States");
//        test.put("city", "Los Angeles");
//        test.put("age", "31");

//        test.put("111", null);
//        test.put("222", null);
//        test.put("333", null);
//        test.put("444", null);
//        test.put("555", null);

        System.out.println(getQuery(test));

    }
    public static String getQuery(Map<String, String> params) {

        String name = null;
        String nameK = null;

        String country = null;
        String countryK = null;

        String city = null;
        String cityK = null;

        String age = null;
        String ageK = null;

        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;



        for (Map.Entry<String,String> para : params.entrySet()){
            switch(count){
                case 0:
                    name = para.getValue();
                    nameK = para.getKey();
                    break;
                case 1:
                    country = para.getValue();
                    countryK = para.getKey();
                    break;
                case 2:
                    city = para.getValue();
                    cityK = para.getKey();
                    break;
                case 3:
                    age = para.getValue();
                    ageK = para.getKey();
                    break;
            }
            count++;
        }

//        for (Map.Entry<String,String> para : params.entrySet()) {
//            sbLength = stringBuilder.toString().length();
//            switch (para.getKey()) {
//                case "name":
//                    if (para.getValue() == null) break;
//                    else {
//                        tempValue = String.format("name = '%s'", para.getValue());
//                        stringBuilder.insert(1,tempValue);
//                    }
//                    if (count < size) {
//                        stringBuilder.append(" and ");
//                        count++;
//                    }
//                    break;
//                case "country":
//                    if (para.getValue() == null) break;
//                    else {
//                        tempValue = String.format("country = '%s'", para.getValue());
//                        stringBuilder.insert(1,tempValue);
//                    }
//                    if (count < size) {
//                        stringBuilder.append(" and ");
//                        count++;
//                    }
//                    break;
//                case "city":
//                    if (para.getValue() == null) break;
//                    else {
//                        tempValue = String.format("city = '%s'", para.getValue());
//                        stringBuilder.insert(1,tempValue);
//                    }
//                    if (count < size) {
//                        stringBuilder.append(" and ");
//                        count++;
//                    }
//                    break;
//                case "age":
//                    if (para.getValue() == null) break;
//                    else {
//                        tempValue = String.format("age = '%s'", para.getValue());
//                        stringBuilder.insert(1,tempValue);
//                    }
//                    if (count < size) {
//                        stringBuilder.append(" and ");
//                        count++;
//                    }
//                    break;
//            }
//            count++;
//
//        }

        if (name != null) stringBuilder.append(String.format("%s = '%s'", nameK, name));
        if ((name != null && country != null) || (name != null && city != null) || (name != null && age != null)) stringBuilder.append(" and ");
        if (country != null) stringBuilder.append(String.format("%s = '%s'", countryK, country));
        if ((country != null && city != null) || (country != null && age != null)) stringBuilder.append(" and ");
        if (city != null) stringBuilder.append(String.format("%s = '%s'", cityK, city));
        if (city != null && age != null) stringBuilder.append(" and ");
        if (age != null) stringBuilder.append(String.format("%s = '%s'", ageK, age));



        return stringBuilder.toString();
    }
}
