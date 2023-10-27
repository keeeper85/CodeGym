package com.codegym.task.task25.task2502;

import java.util.*;

/* 
Don't take the car to the shop!
Initialize the wheels field using data from loadWheelNamesFromDB().
Throw an exception if the data is invalid.

Hint: if wheels aren't right, then it's not a car!
Don't change the signatures.


Requirements:
1. Don't change the Wheel enum in the Solution class.
2. Don't change signatures in the Car class.
3. When creating a car, you need to call the loadWheelNamesFromDB() method.
4. If incorrect wheel data is returned, then you need to throw an exception.
5. Initialize the wheels field with the returned data.

*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            // Init wheels here

            wheels = new ArrayList<>();

            //wheels.add(Wheel.valueOf(loadWheelNamesFromDB()[1]));

            if (loadWheelNamesFromDB().length != 4) throw new RuntimeException();

            for (String values : loadWheelNamesFromDB()){
                if (Wheel.BACK_LEFT.equals(Wheel.valueOf(values)) && (!wheels.contains(Wheel.valueOf(values)))) wheels.add(Wheel.valueOf(values));
                else if (Wheel.BACK_RIGHT.equals(Wheel.valueOf(values)) && (!wheels.contains(Wheel.valueOf(values)))) wheels.add(Wheel.valueOf(values));
                else if (Wheel.FRONT_RIGHT.equals(Wheel.valueOf(values)) && (!wheels.contains(Wheel.valueOf(values)))) wheels.add(Wheel.valueOf(values));
                else if (Wheel.FRONT_LEFT.equals(Wheel.valueOf(values)) && (!wheels.contains(Wheel.valueOf(values)))) wheels.add(Wheel.valueOf(values));
                else throw new RuntimeException();
            }


        }
        protected String[] loadWheelNamesFromDB() {
            // This method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {

        Car car = new Car();

        //System.out.println(car.wheels.get(0));

        for (Wheel values : car.wheels){
            System.out.println(values.toString());
        }
    }
}
