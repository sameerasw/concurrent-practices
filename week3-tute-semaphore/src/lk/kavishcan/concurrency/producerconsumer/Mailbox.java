package lk.kavishcan.concurrency.producerconsumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Mailbox {
    private Queue<Integer> queue = new ArrayDeque<>(); // shared resource
    private Semaphore emptySlots; // track empty slots
    private Semaphore fullSlots; // track fulls lots
    private Semaphore mutex; // to protect the critical section
    private int capacity;

    public Mailbox(int capacity) {
        this.capacity = capacity;
        emptySlots = new Semaphore(capacity);
        fullSlots = new Semaphore(0);
        mutex = new Semaphore(1);
    }

    public synchronized void put(int value) throws InterruptedException {
            try {
                emptySlots.acquire(); // an item is added to the queue if a permit awaits or wait.
                mutex.acquire(); // acquire lock before entering the critical section (shared variable queue)
                queue.offer(value);
                System.out.println(Thread.currentThread().getName() + " - Produced: " + value);
            } finally {
                mutex.release(); // release the lock
                emptySlots.release(); // release the permit since the process is done
            }
    }

    public synchronized int get() throws InterruptedException {
            try{
                fullSlots.acquire();
                mutex.acquire();
                int value = queue.poll();
                System.out.println(Thread.currentThread().getName() + " - Produced: " + queue.poll());
                return value;
            } finally {
                mutex.release();
                fullSlots.release();
            }
    }
}
