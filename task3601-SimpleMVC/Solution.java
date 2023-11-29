package com.codegym.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/* 
MVC - a simplified version

Create the Service, Model, View, and Controller classes in separate files.
Move the Solution class's methods to the created classes in accordance with how MVC should work.
Create the required fields in the classes as needed. Don't add any other methods of your own.
Leave the main method in the Solution class.

*/

public class Solution {
    public static void main(String[] args) {

//        Model model = new Model();
        View view = new View();
//        Controller controller = new Controller();

//        view.controller = controller;
//        controller.model = model;

        view.fireShowDataEvent();
    }








}
