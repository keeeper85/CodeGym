package com.codegym.task.task21.task2111;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/* 
Release resources
Implement the finalize method after first thinking about what exactly it should contain.
Refactor the getUsers method to use the Java 7 try-with-resources construct.


Requirements:
1. The Solution class's finalize method must have a call to super.finalize().
2. The Solution class's finalize method should terminate correctly if the connection field is equal to null.
3. The Solution class's finalize method must close the current connection if the connection field is not equal to null.
4. The getUsers method must use try-with-resources correctly.

*/

public class Solution {
    private Connection connection;

    public Solution(Connection connection) {
        this.connection = connection;
    }

    public List<User> getUsers() throws SQLException {
        String query = "select ID, DISPLAYED_NAME, LEVEL, LESSON from USER";

        List<User> result = new LinkedList();

//        Statement stmt = null;
//        ResultSet rs = null;

//        try {
//            stmt = connection.createStatement();
//            rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                int id = rs.getInt("ID");
//                String name = rs.getString("DISPLAYED_NAME");
//                int level = rs.getInt("LEVEL");
//                int lesson = rs.getInt("LESSON");
//
//                result.add(new User(id, name, level, lesson));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            result = null;
//        } finally {
//            if(stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("DISPLAYED_NAME");
                int level = rs.getInt("LEVEL");
                int lesson = rs.getInt("LESSON");

                result.add(new User(id, name, level, lesson));
            }
        }

        return result;
    }

    public static class User {
        private int id;
        private String name;
        private int level;
        private int lesson;

        public User(int id, String name, int level, int lesson) {
            this.id = id;
            this.name = name;
            this.level = level;
            this.lesson = lesson;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", level=" + level +
                    ", lesson=" + lesson +
                    '}';
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (connection != null) connection.close();
    }

    public static void main(String[] args) {

    }
}
