package com.codegym.task.task40.task4012;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;

/* 
Useful methods of the DateTime API

ava 8's DateTime API implements many classes and methods that greatly simplify working with dates and times.
Let's implement a few simple methods to get to know them better.
1) The isLeap method must accept a date and return true if the year is a leap year, otherwise it must return false.
2) The isBefore method must accept a date and return true if it is before the current date, otherwise it must return false.
3) The addTime method must return the passed time plus n ChronoUnits.
4) The getPeriodBetween method must take two dates and return the time interval between them.
Remember, the earlier date must be passed before the later date to the Period.between method.

*/

public class Solution {
    public static void main(String[] args) {

//        LocalDate date = LocalDate.ofYearDay(2020, 1);
//        LocalTime time = LocalTime.now();
//        System.out.println(getPeriodBetween(date, LocalDate.now()).getYears());

    }

    public static boolean isLeap(LocalDate date) {

        return date.isLeapYear();

    }

    public static boolean isBefore(LocalDateTime dateTime) {

        return dateTime.isBefore(LocalDateTime.now());

    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {

        return time.plus(n, chronoUnit);
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {

        if (firstDate.isBefore(secondDate)){
            return Period.between(firstDate, secondDate);
        }
        return Period.between(secondDate, firstDate);
    }
}
