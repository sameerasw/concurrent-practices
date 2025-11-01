public class ThreadLifeCycle {
    public static void main(String[] args) throws InterruptedException {
        WorkerThread workerthread1 = new WorkerThread("workerthread1");
        WorkerThread workerthread2 = new WorkerThread("workerthread2");

        workerthread1.start();
        System.out.println("worker thread is in RUNNABLE state");
        workerthread2.start();

        for (int i = 0; i <= 5; i++) {
            System.out.println("Main thread executing... " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
// Notify the worker thread to move from WAITING -> RUNNABLE state


        synchronized (WorkerThread.class) {
            System.out.println("Main thread notifying the waiting worker thread");
            WorkerThread.class.notify();
        }
// Wait for the worker thread to complete execution (join ensures worker thread TERMINATED state)
        workerthread1.join();
        workerthread2.join();

        System.out.println("Worker thread is in TERMINATED state");
// Main thread has finished its execution after worker thread
        System.out.println("Main thread is in TERMINATED state");
    }
}