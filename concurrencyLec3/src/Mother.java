public class Mother<E> implements Runnable {
    private final Plate plate;
    private E[] items;

    public Mother(Plate plate, E[] items) {
        this.plate = plate;
        this.items = items;
    }

    @Override
    public void run() {
        for (E food : items) {
            plate.put(food);
            System.out.println(Thread.currentThread().getName() + " serves: " + "food " + food);
        }
    }
}