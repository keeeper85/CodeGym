package com.codegym.task.task25.task2506;

public class LoggingStateThread extends Thread{

    Thread thread;
    State state;
    public LoggingStateThread(Thread target) {
        this.thread = target;
        //thread.setDaemon(true);
    }

    @Override
    public void run(){

        super.run();
        state = thread.getState();
        System.out.println(state);

        while (state != State.TERMINATED){
            if (state != thread.getState()){
                state = thread.getState();
                System.out.println(state);
            }
        }

    }
}
