package com.codegym.task.task30.task3003;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/* 
Saving time

1. Create a Producer and Consumer (See the comments on the main method).

2. Create toString, equals, and hashCode methods in the SharedItem class. To do this in IntelliJ IDEA, do the following in the body of the SharedItem class:
2.1. Alt+Insert -> toString() -> Enter.
2.2. Alt+Insert -> equals() and hashCode() -> click 'Next' every time.
2.3. Leave IntelliJ IDEA's implementation of the toString(), equals(), and hashCode() methods as it is.

3. In Producer and Consumer, implement the run method so that calling the interrupt method interrupts the consumer and producer threads.

4. Implement the Producer's run method:
4.1. Using the offer method, add 9 SharedItems to the queue, with the following arguments: ("SharedItem-N", N), where N is a item number from 1 to 9.
4.2. Before each addition, display the phrase "'SharedItem-N' added". Use System.out.format.
4.3. Put the thread to sleep for 0.1 seconds.
4.4. If the queue has a Consumer that is not busy working, then display the phrase "Consumer is waiting!".
Take a look at the methods of the TransferQueue interface. You'll find the method you need.

5. Implement the Consumer's run method:
5.1. Put the thread to sleep for 0.45 seconds.
5.2. In an infinite loop, use the take method to get an item from the queue and display "Processing item.toString()".

6. Check the output against the output.txt file.

7. Don't display the stack trace on the console.

8. Use System.out.format to display any information on the screen.

*/

public class Solution {
    /*
    1. Create a Producer class. To do this, click Alt+Enter -> Create Class... on the red class name.
    2. Point at the parameter name in the constructor (queue) and click Alt+Enter -> Create Field for Parameter 'queue' -> Enter -> Enter. The field name is queue.
    3. Point at the underlined class description. Then Alt+Enter -> Implement Methods -> Enter.
    4. Do items 1-3 for the Consumer class.


     */

    public static void main(String[] args) throws InterruptedException {
        TransferQueue<SharedItem> queue = new LinkedTransferQueue<>();

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();

        Thread.sleep(1500);

        producer.interrupt();
        consumer.interrupt();
    }

}
