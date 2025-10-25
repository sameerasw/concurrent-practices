package com.sameerasw.concurrent;

public class Producer implements Runnable {
    private Mailbox mailbox;

    public Producer(Mailbox mailbox) {
        this.mailbox = mailbox;
    }

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
                mailbox.setMail(i);
                System.out.println(Thread.currentThread().getName() + " set mail " + i );
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
