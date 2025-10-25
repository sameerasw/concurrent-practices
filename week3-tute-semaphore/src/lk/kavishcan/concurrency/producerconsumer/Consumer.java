package lk.kavishcan.concurrency.producerconsumer;

public class Consumer implements Runnable {
    private final Mailbox mailbox;

    public Consumer(Mailbox mailbox) {
        this.mailbox = mailbox;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                mailbox.get();
                // Simulate time taken to consume an item
                Thread.sleep((int)(Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
