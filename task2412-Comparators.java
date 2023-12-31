package com.codegym.task.task24.task2412;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Knowledge is power!
1. In the sort method, write a comparator for Stock:
1.1. Sort first by name in alphabetical order
1.2. Sort second by date without accounting for hours, minutes, and seconds (with the newest on top), and then by profit from positive to negative

... open 125.64 and last 126.74. Here the gain is 126.74-125.64
... open 125.64 and last 123.43. Here the gain is 123.43-125.64

2. Take a look at the *Format classes and fix the IllegalArgumentException.
Hint: it's one line.

Example output:

Fake Apple Inc.   AAPL | 16-03-2027 open 125.64 and last 123.43
Fake Applied Materials, Inc.   AMAT | 15-01-1983 change 0.26

Requirements:
1. No exceptions should occur while the program is running.
2. The program should display data on the screen.
3. The sort method must correctly sort the passed list according to the task conditions.
4. The Solution.Stock class must be public.
*/

public class Solution {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"closed {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, null, dateFormat, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void sort(List<Stock> list) {
        Collections.sort(list, new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {

                int nameCompare = stock1.get("name").toString().compareTo(stock2.get("name").toString());

                Date dateStock1, dateStock2;

                dateStock1 = (Date) stock1.get("date");

                dateStock1.setHours(0);
                dateStock1.setMinutes(0);
                dateStock1.setSeconds(0);

                dateStock2 = (Date) stock2.get("date");

                dateStock2.setHours(0);
                dateStock2.setMinutes(0);
                dateStock2.setSeconds(0);

                int dateCompare = dateStock2.compareTo(dateStock1);

                Double profit1 = !stock1.containsKey("change")? (Double) stock1.get("last") - (Double) stock1.get("open") : (Double) stock1.get("change");
                Double profit2 = !stock2.containsKey("change")? (Double) stock2.get("last") - (Double) stock2.get("open") : (Double) stock2.get("change");

                int profitCompare = profit2.compareTo(profit1);

                if (nameCompare !=0) return nameCompare;
                else if(dateCompare != 0) return dateCompare;
                else return profitCompare;

            }
        });
    }

    public static class Stock extends HashMap<String, Object> {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));

        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}

