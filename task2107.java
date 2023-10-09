package com.codegym.task.task21.task2107;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Deep cloning of a map

*/

public class Solution implements Cloneable{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(users, solution.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public Object clone(){
            User user = new User(this.age, this.name);

            return user;
        }
    }

    public Object clone(){
        Solution solution = new Solution();

        Map<String, User> mapa = new LinkedHashMap<>();

        for (Map.Entry<String, User> para : users.entrySet()){
            mapa.put(para.getKey(), para.getValue());
        }

        for (Map.Entry<String, User> para : mapa.entrySet()){
            solution.users.put(para.getKey(), para.getValue());
        }

        return solution;
    }
}
