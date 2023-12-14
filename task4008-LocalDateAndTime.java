package com.codegym.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/*
Working with Java 8's DateTime API

Complete this task using Java 8's DateTime API.

Implement the printDate(String date) method.
It must accept a date as an argument (in one of 3 formats)
and display it as follows:

1) For "9.10.2017 5:56:45", the output must be:
Day: 9
Day of the week:
Day of the month: 9
Day of the year: 282
Week of the month: 3
Week of the year: 42
Month: 10
Year: 2017
AM or PM: PM
Hour: 5
Hour of the day: 5
Minutes: 56
Seconds: 45

2) For "21.4.2014":
Day: 21
Day of the week: 1
Day of the month: 21
Day of the year: 111
Week of the month: b
Week of the year: 17
Month: 4
Year: 2014

3) For "17:33:40":
AM or PM: PM
Hour: 5
Hour of the day: 17
Minutes: 33
Seconds: 40

*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");

    }

    public static void printDate(String date) {
        //write your code here

        DateTimeFormatter formatter;
        LocalDate localDate;
        LocalTime localTime;

        try{
            formatter = DateTimeFormatter.ofPattern("d.M.yyyy H:m:s");
            localDate = LocalDate.parse(date, formatter);
            localTime = LocalTime.parse(date, formatter);
            int hour = localTime.getHour();
            int minute = localTime.getMinute();

            System.out.println("Day: " + localDate.getDayOfMonth());
            System.out.println("Day of the week: " + localDate.getDayOfWeek().getValue());
            System.out.println("Day of the month: " + localDate.getDayOfMonth());
            System.out.println("Day of the year: " + localDate.getDayOfYear());
            System.out.println("Week of the month: " + localDate.format(DateTimeFormatter.ofPattern("W")));
            System.out.println("Week of the year: " + localDate.format(DateTimeFormatter.ofPattern("w")));
            System.out.println("Month: " + localDate.getMonth().getValue());
            System.out.println("Year: " + localDate.getYear());
            System.out.println("AM or PM: " + amOrPm(hour, minute));
            System.out.println("Hour: " + hour12format(hour));
            System.out.println("Hour of the day: " + localTime.getHour());
            System.out.println("Minutes: " + localTime.getMinute());
            System.out.println("Seconds: " + localTime.getSecond());

        } catch (Exception ignored){
        }

        try{
            formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
            localDate = LocalDate.parse(date, formatter);

            System.out.println("Day: " + localDate.getDayOfMonth());
            System.out.println("Day of the week: " + localDate.getDayOfWeek().getValue());
            System.out.println("Day of the month: " + localDate.getDayOfMonth());
            System.out.println("Day of the year: " + localDate.getDayOfYear());
            System.out.println("Week of the month: " + localDate.format(DateTimeFormatter.ofPattern("W")));
            System.out.println("Week of the year: " + localDate.format(DateTimeFormatter.ofPattern("w")));
            System.out.println("Month: " + localDate.getMonth().getValue());
            System.out.println("Year: " + localDate.getYear());

        } catch (Exception ignored){

        }

        try{
            formatter = DateTimeFormatter.ofPattern("H:m:s");
            localTime = LocalTime.parse(date, formatter);
            int hour = localTime.getHour();
            int minute = localTime.getMinute();

            System.out.println("AM or PM: " + amOrPm(hour, minute));
            System.out.println("Hour: " + hour12format(hour));
            System.out.println("Hour of the day: " + localTime.getHour());
            System.out.println("Minutes: " + localTime.getMinute());
            System.out.println("Seconds: " + localTime.getSecond());

        } catch (Exception ignored){

        }
    }

    public static String amOrPm(int hour, int minute){

        if (hour > 0 && hour < 12) return "AM";
        if (hour == 0 && minute > 0 && hour < 12) return "AM";
        if (hour == 12 && minute == 0) return "AM";
        return "PM";

    }

    public static String hour12format(int hour){

        if (hour > 12) return String.valueOf((hour - 12));
        return String.valueOf(hour);
    }
}
