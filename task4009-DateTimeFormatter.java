package com.codegym.task.task40.task4009;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Buon Compleanno!

Implement the getWeekdayOfBirthday method.
The method must return the day of the week for a birthday in a given year (past, present, or future), in Italian.
See the main method for example date formats.
Example:
1) For "30.05.1984" and "2015", the method must return: sabato
2) For "1.12.2015" and "2016", the method must return: gioved?

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
        System.out.println(getWeekdayOfBirthday("1.12.2015", "2016"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        //write your code here

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate localDate =  LocalDate.parse(birthday, formatter);
        Year parsedYear = Year.parse(year);
        String givenYearBD = localDate.getDayOfMonth() + "." + localDate.getMonthValue() + "." + parsedYear.getValue();

        LocalDate localDate2 =  LocalDate.parse(givenYearBD, formatter);

        return localDate2.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}