import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Plate {
    private String food = null;
    private final Lock lock = new ReentrantLock(true);
    private final Condition notEmpty = lock.newCondition(); // wait for plate to have food
    private final Condition notFull = lock.newCondition();  // wait for plate to be empty

    public void produce(String food) {
        lock.lock();
        try {
            while (this.food != null) {
                notFull.await(); // wait if plate already has food
            }
            this.food = food;
            System.out.println("Produced: " + food);
            notEmpty.signal(); // notify consumer
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public String consume() {
        lock.lock();
        try {
            while (this.food == null) {
                notEmpty.await(); // wait if plate is empty
            }
            String eatenFood = this.food;
            this.food = null;
            System.out.println("Consumed: " + eatenFood);
            notFull.signal(); // notify producer
            return eatenFood;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } finally {
            lock.unlock();
        }
    }
}
