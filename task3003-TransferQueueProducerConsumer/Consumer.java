package com.codegym.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private final TransferQueue<SharedItem> queue;

    public Consumer(TransferQueue<SharedItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
            while (!Thread.currentThread().isInterrupted()){
                SharedItem item = queue.take();
                System.out.format("Processing %s", item.toString());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
