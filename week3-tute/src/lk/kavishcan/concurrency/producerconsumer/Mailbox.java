package lk.kavishcan.concurrency.producerconsumer;

import java.util.ArrayDeque;
import java.util.Queue;

public class Mailbox {
    private Queue<Integer> queue = new ArrayDeque<>(); // shared resource
    private int capacity;

    public Mailbox(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(int value) throws InterruptedException {
            while (queue.size() >= capacity) {
                wait();
            }
            queue.offer(value);
            System.out.println(Thread.currentThread().getName() + " - Produced: " + value);
            notifyAll();
    }

    public synchronized int get() throws InterruptedException {
            while (queue.isEmpty()) {
               wait();
            }
            int value = queue.poll();
            System.out.println(Thread.currentThread().getName() + " - Consumed: " + value);
            notifyAll();
            return value;
    }
}
