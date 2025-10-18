import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CoffeeShop {
   private Queue<String> queue = new ArrayDeque<String>();
   private int capacity;
    private final Lock lock = new ReentrantLock(true);
    private final Condition notEmpty = lock.newCondition(); // wait for plate to have food
    private final Condition notFull = lock.newCondition();

    public CoffeeShop(int capacity) {
        this.capacity = capacity;
    }

    public void placeOrder(String order) {
        try {
            lock.lock();
            while (queue.size() == capacity) {
                try {
                    wait();
                }  catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            queue.offer(order);
            notFull.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public String takeOrder() {
        try {
            lock.lock();
            while (!queue.isEmpty()) {
                try {
                    notFull.wait();
                }  catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            notEmpty.signalAll();
            return queue.poll();

        } finally {
            lock.unlock();
        }

    }
}
