public class Main {
    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName());

        Thread thread1 = new MyThread("thread1"); // The state of the thread is in NEW state

        // will execute in the main thread
//        thread.run();

        // brings the thread to the RUNNABLE state and executes in own thread
        thread1.start();

        // ----------------------------------------

        // Initiate as a runnable so we can easily replace the exact object of the same super type to avoid strong bonds
        Runnable myRunnable = new MyThread2();

        // Use the Thread constructor with passing the Runnable and Thread name in this occasion
        Thread thread2 = new Thread(myRunnable, "thread2");

        // Start the thread 2
        thread2.start();

        // -----------------------------------------

        // lambda function for one time use
        Thread thread3 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }, "thread3");

        // Start thread3
        thread3.start();

        // -----------------------------------------

        // deprecated anonymous inner class method
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            }
        }, "thread4");

        // start thread4
        thread4.start();

        // -----------------------------------------

        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}