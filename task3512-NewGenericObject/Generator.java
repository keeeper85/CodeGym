package com.codegym.task.task35.task3512;

public class Generator<T> {

    private Class<T> clazz;

    public Generator(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T newInstance() throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }
}
