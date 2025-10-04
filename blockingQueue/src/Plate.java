import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Plate {
    private BlockingQueue<String> serving = new ArrayBlockingQueue<String>(1);

    public Plate(String food) {
    }

    public void produce(String food) {

        try {
           serving.put(food);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String consume() {

        try {
            return serving.take(); // unlike take, poll doesn't wait
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
