package com.codegym.task.task38.task3811;

/* 
Tickets

Implement a Ticket annotation in a separate file.
It has the following requirements:
1) It must be public and accessible at runtime.
2) It can only be applied to new data types (class, interface [including annotations], or enum declarations).
3) It must have a Priority enum with LOW, MEDIUM, and HIGH fields.
4) A priority property will set the priority. Priority.MEDIUM is the default value.
5) The tags property will be a String array and will store tags associated with the ticket.
6) The createdBy property will be a String whose default value is "Amigo".

*/

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



@Ticket (
        priority = Ticket.Priority.HIGH,
        createdBy = "Noodles",
        tags = {"bug","fix asap"}
)
public class Solution {
    public static void main(String[] args) {
        
    }
}
