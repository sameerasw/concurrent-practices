package com.sameerasw.tut07;

import java.util.concurrent.Semaphore;

public class Cafe {
    private final Semaphore mutex = new Semaphore(1);
    private int currentStock = 0;

    public void make() throws InterruptedException {
        try {
            mutex.acquire(); // acquire lock before entering the critical section (shared variable queue)
            currentStock += 1;
            System.out.println(Thread.currentThread().getName() + " - Added stock  " + currentStock + " available");
        } finally {
            mutex.release(); // release the lock
        }
    }

    public void sell() throws InterruptedException {
        try{
            mutex.acquire();
            if(currentStock > 0){
                currentStock -= 1;
                System.out.println(Thread.currentThread().getName() + " - Sold stock  " + currentStock + " available");
            }
        } finally {
            mutex.release();
        }
    }
}
