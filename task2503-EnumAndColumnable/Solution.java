package com.codegym.task.task25.task2503;

/* 
Your own enum
Make Column implement the Columnable interface. See the Javadocs for a description of its methods.
Implement the logic of the Column.getVisibleColumns() method.
The Column.configureColumns() method is already implemented. Don't change it.
Don't create additional fields.
The main() method is not tested.


Requirements:
1. Don't change the Columnable interface.
2. The Column class must implement the Columnable interface.
3. Don't create additional fields in the Column class.
4. The Column.configureColumns() method is already implemented. Don't change it.
5. The Column.getVisibleColumns() method must return a list of visible columns in the specified order.
6. The Column.getColumnName() method must return a column's full name.
7. The Column.isShown() method must return true if the column is visible. Otherwise, it must return false.
8. The Column.hide() method must hide the column and shift the indices of the other visible columns.
*/

public class Solution {
    /**
     * Output:
     * <p/>
     * Available Amount
     * Account Number
     * Bank Name
     * --------------------
     * Available Amount
     * Bank Name
     */
    public static void main(String[] args) {

        Column.configureColumns(Column.Amount, Column.AccountNumber, Column.BankName);

//        for (Integer values : Column.realOrder){
//            System.out.println(values);
//        }

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }

        System.out.println("--------------------");
        Column.AccountNumber.hide();

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }

//        for (Integer values : Column.realOrder){
//            System.out.println(values);
//        }
    }
}
