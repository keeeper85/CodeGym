package com.codegym.task.task38.task3810;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Date {
    // Write your own code

    int day();
    int month();
    int year();
    int hour();
    int minute();
    int second();
}