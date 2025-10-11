import java.util.ArrayList;
import java.util.List;

public class MultiSlotPlate implements Plate{
    private List<String> plate = new ArrayList<>();
    private int capacity;

    public MultiSlotPlate(int capacity){
        this.capacity = capacity;
    }

    @Override
    public synchronized void produce(String food) {
        while (plate.size() == capacity){
            try{
                wait();
            }catch (InterruptedException e){}
        }

        plate.add(food);
        System.out.println("Produced: " + food);
        notifyAll();
    }

    @Override
    public synchronized String consume() {
        while (plate.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String food = plate.remove(0);

        System.out.println("Consumed: " + food);
        notifyAll();
        return food;
    }
}
