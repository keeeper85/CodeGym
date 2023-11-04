package com.codegym.task.task27.task2710;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        String name = Thread.currentThread().getName();
        // do something here
        while (mail.getText() == null) {
            synchronized (mail){
                try {
                    mail.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }



            long endTime = System.currentTimeMillis();
            System.out.format("%s MailServer received: [%s] in %d ms after start", name, mail.getText(), (endTime - startTime));


    }
}
