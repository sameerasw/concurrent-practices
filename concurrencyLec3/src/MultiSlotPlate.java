import java.util.*;

public class MultiSlotPlate implements Plate {
    private List<String> plate = new ArrayList<>();
    private int capacity;
    private boolean closed;

    public MultiSlotPlate(int capacity) {
        this.capacity = capacity;
        this.closed = false;
    }

    @Override
    public synchronized void put(String food) {
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
    public synchronized String get() {
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

        String food = plate.remove(0);
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
