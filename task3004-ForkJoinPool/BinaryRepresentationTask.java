package com.codegym.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        if (x == 1) return "1";
        if (x < 1) return "0";

        BinaryRepresentationTask b1 = new BinaryRepresentationTask(x % 2);
        b1.fork();
        BinaryRepresentationTask b2 = new BinaryRepresentationTask(x / 2);
        return b2.compute() + b1.join();
    }
}
