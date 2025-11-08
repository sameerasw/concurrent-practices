package com.sameerasw.tut07;

public class Barista implements Runnable {
    private final Cafe cafe;

    public Barista(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public void run() {
        while(true){
            int randomNumber = (int) (Math.random() * 500);
            try {
                Thread.sleep(randomNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                cafe.make();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
