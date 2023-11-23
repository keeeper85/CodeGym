package com.codegym.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonAutoDetect
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "className")

public abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}