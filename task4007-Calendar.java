package com.codegym.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/*
Working with Java 8's DateTime API

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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = null;
        String result = null;

        try {
            if (date.matches("\\d{1,2}[.]\\d{1,2}[.]\\d{4}[ ]\\d{1,2}[:]\\d{2}[:]\\d{2}")) {
                dateFormat = new SimpleDateFormat("d.M.yyyy HH:mm:ss");
                calendar.setTime(dateFormat.parse(date));
                result = getFullDateResult(calendar);

            } else if (date.matches("\\d{1,2}[.]\\d{1,2}[.]\\d{4}")) {
                dateFormat = new SimpleDateFormat("d.M.yyyy");
                calendar.setTime(dateFormat.parse(date));
                result = getDateResult(calendar);

            } else if (date.matches("\\d{1,2}[:]\\d{2}[:]\\d{2}")) {
                dateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar.setTime(dateFormat.parse(date));
                result = getTimeResult(calendar);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.print(result);
    }

    private static String getFullDateResult(Calendar calendar) {
        StringBuilder result = new StringBuilder();
        result.append(getDateResult(calendar));
        result.append(getTimeResult(calendar));

        return result.toString();
    }

    private static String getDateResult(Calendar calendar) {
        StringBuilder dateBuilder = new StringBuilder();

        dateBuilder.append("Day: ");
        dateBuilder.append(calendar.get(Calendar.DAY_OF_MONTH));
        dateBuilder.append("\n");

        dateBuilder.append("Day of the week: ");
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        dateBuilder.append(dayOfWeek > 1 ? dayOfWeek - 1 : 7);
        dateBuilder.append("\n");

        dateBuilder.append("Day of the month: ");
        dateBuilder.append(calendar.get(Calendar.DAY_OF_MONTH));
        dateBuilder.append("\n");

        dateBuilder.append("Day of the year: ");
        dateBuilder.append(calendar.get(Calendar.DAY_OF_YEAR));
        dateBuilder.append("\n");

        dateBuilder.append("Week of the month: ");
        dateBuilder.append(calendar.get(Calendar.WEEK_OF_MONTH));
        dateBuilder.append("\n");

        dateBuilder.append("Week of the year: ");
        dateBuilder.append(calendar.get(Calendar.WEEK_OF_YEAR));
        dateBuilder.append("\n");

        dateBuilder.append("Month: ");
        dateBuilder.append(calendar.get(Calendar.MONTH) + 1);
        dateBuilder.append("\n");

        dateBuilder.append("Year: ");
        dateBuilder.append(calendar.get(Calendar.YEAR));
        dateBuilder.append("\n");

        return dateBuilder.toString();
    }

    private static String getTimeResult(Calendar calendar) {
        StringBuilder dateBuilder = new StringBuilder();
        dateBuilder.append("AM or PM: ");
        dateBuilder.append(calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.ENGLISH));
        dateBuilder.append("\n");

        dateBuilder.append("Hour: ");
        dateBuilder.append(calendar.get(Calendar.HOUR));
        dateBuilder.append("\n");

        dateBuilder.append("Hour of the day: ");
        dateBuilder.append(calendar.get(Calendar.HOUR_OF_DAY));
        dateBuilder.append("\n");

        dateBuilder.append("Minutes: ");
        dateBuilder.append(calendar.get(Calendar.MINUTE));
        dateBuilder.append("\n");

        dateBuilder.append("Seconds: ");
        dateBuilder.append(calendar.get(Calendar.SECOND));
        dateBuilder.append("\n");

        return dateBuilder.toString();
    }
}
