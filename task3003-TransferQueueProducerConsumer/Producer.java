package com.codegym.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private final TransferQueue<SharedItem> queue;
    private boolean busy = false;

    public Producer(TransferQueue<SharedItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {

            if (Thread.currentThread().isInterrupted()) break;

            System.out.format("'SharedItem-%d' added", i);
            try {
            String itemDescription = String.format("SharedItem-%d", i);
            SharedItem item = new SharedItem(itemDescription, i);
            queue.offer(item);

            Thread.sleep(100);
            if (queue.hasWaitingConsumer()) System.out.format("Consumer is waiting!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isBusy() {
        return busy;
    }
}
