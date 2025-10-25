package lk.kavishcan.concurrency.producerconsumer;

public class Producer implements  Runnable {
    private final Mailbox mailbox;

    public Producer(Mailbox mailbox) {
        this.mailbox = mailbox;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                mailbox.put(i);
                // Simulate time taken to produce an item
                Thread.sleep((int)(Math.random() * 100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
