package com.codegym.task.task27.task2709;

/* 
Producer–consumer

In the TransferObject class, arrange calls to the wait/notify/notifyAll methods to ensure the sequential production and consumption of objects.
In the run methods of the ConsumerTask and ProducerTask classes, create the necessary synchronized blocks.

Expected output:

... Put: M Got: M Put: N Got: N Put: K Got: K ...
where M, N, and K are numbers
The main method is not tested

P.S. Always try to use a concurrent collection rather than using the wait/notify/notifyAll methods manually.
Tasks like this help you better understand the basics of how multithreaded applications work.

*/

public class Solution {
    public static void main(String args[]) throws InterruptedException {
        TransferObject transferObject = new TransferObject();
        ProducerTask producerTask = new ProducerTask(transferObject);
        ConsumerTask consumerTask = new ConsumerTask(transferObject);

        Thread.sleep(50);
        producerTask.stop();
        consumerTask.stop();
    }
}
