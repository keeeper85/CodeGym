package com.codegym.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Writing our own ThreadFactory

In the Solution class, create a public static AmigoThreadFactory class that implements the ThreadFactory interface.
1. The implementation of the interface's method must create and return a thread that:
1.1. is not a daemon,
1.2. has a normal priority level,
1.3. The thread's name must follow the pattern "GN-pool-A-thread-B" where:
GN is the group name,
A is the factory number, which is incremented inside the class, starting from 1 (use AtomicInteger),
B is the thread number, which is incremented inside a specific factory, starting from 1 (use AtomicInteger).
2. Each factory must contain the thread group (ThreadGroup) it was created in.
3. The main and emulateThreadFactory methods are not tested.

*/

public class Solution {

    public static AtomicInteger classAtom = new AtomicInteger(1);

    public static void main(String[] args) {


        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                //classAtom.getAndIncrement();
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {

        AmigoThreadFactory factory = new AmigoThreadFactory();

        Runnable r = new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory{

        AtomicInteger threadAtom = new AtomicInteger(0);
        public int factoryNumber = Solution.classAtom.getAndIncrement();

        @Override
        public Thread newThread(Runnable r) {

            Thread thread = new Thread(r);
            threadAtom.getAndIncrement();
            thread.setDaemon(false);
            thread.setPriority(5);
//            "GN-pool-A-thread-B"
//            String name = String.valueOf(factoryAtom.incrementAndGet());
            String group = Thread.currentThread().getThreadGroup().getName();
            String label;

//            System.out.println(threadAtom);
//            System.out.println(Solution.classAtom);
//            System.out.println(group);

//            switch (group){
//                case "firstGroup":
//                    label = String.format("%s-pool-1-thread-%s", group, threadAtom);
////                    label = "test1";
//                    thread.setName(label);
//                    break;
//                case "secondGroup":
//                    label = String.format("%s-pool-2-thread-%s", group, threadAtom);
////                    label = "test2";
//                    thread.setName(label);
//                    break;
//            }

            thread.setName(String.format("%s-pool-%d-thread-%s", group, factoryNumber, threadAtom));

            return thread;
        }
    }
}
