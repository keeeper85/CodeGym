package com.codegym.task.task25.task2503;

import java.util.*;

public enum Column implements Columnable{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Specifies a new column display order, which is saved in the realOrder array.
     * realOrder[enum index] = display order; -1, if the column is not displayed.
     *
     * @param newOrder new order for displaying the columns in the table
     * @throws IllegalArgumentException if a column is repeated
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Calculates and returns the list of columns to display in a configurable order (see the configureColumns method)
     * Uses the realOrder.
     *
     * @return list of columns
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();

        //every enum entry has its own ordinal number, from 0 to 3
        //method configureColumns gives each entry a new number, according to its agruments
        //value -1 means the entry is hidden and will not be shown
        //array realorder keeps the new values
        //task: prepare a list of visible columns, presented in the new order


        TreeMap<Integer, Column> mapka = new TreeMap<>();
        mapka.put(realOrder[0], Column.Customer);
        mapka.put(realOrder[1], Column.BankName);
        mapka.put(realOrder[2], Column.AccountNumber);
        mapka.put(realOrder[3], Column.Amount);

        for (Map.Entry<Integer, Column> pair : mapka.entrySet()){
            if (pair.getKey() >= 0) result.add(pair.getValue());
        }

        return result;
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
       int x = this.ordinal();
       if (realOrder[x] == -1) return false;
       else return true;
    }

    @Override
    public void hide() {
        int x = this.ordinal();

        realOrder[x] = -1;

        for (int i = 0; i < realOrder.length; i++){
            if (realOrder[i] >= 2) realOrder[i]--;
        }


    }
}
