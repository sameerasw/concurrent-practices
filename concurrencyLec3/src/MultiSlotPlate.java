import java.util.*;

public class MultiSlotPlate<E> implements Plate<E> {
    private List<E> plate = new ArrayList<>();
    private int capacity;
    private boolean closed;

    public MultiSlotPlate(int capacity) {
        this.capacity = capacity;
        this.closed = false;
    }

    @Override
    public synchronized void put(E food) {
        while(!closed && plate.size() == capacity){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        plate.add(food);
        notifyAll();
    }

    @Override
    public synchronized E get() {
        while(!closed && plate.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(plate.isEmpty()){
            return null;
        }

        E food = plate.remove(0);
        notifyAll();
        return food;
    }

    public synchronized void close(){
        closed = true;
        notifyAll();
    }

    public synchronized boolean isClosed(){
        return closed;
    }
}
