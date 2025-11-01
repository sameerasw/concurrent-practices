public class WorkerThread extends Thread {
    public WorkerThread(String name) {
        super(name);
    }
    @Override
    public void run() {
// Implement and display the worker thread’s state transitions
// RUNNABLE state
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
// BLOCKED state use a synchronized(this) block to run the print "BLOCKED"
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
        }

// WAITING state declare in a synchronized(this) with waiting
        synchronized (this) {
            try {
                System.out.println("worker thread is WAITING state");
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
// TIMED_WAITING state, similarly to above, do in a wait(time)
        try {
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            wait(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
// TERMINATED state
    }
}