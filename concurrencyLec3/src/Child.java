public class Child<E> implements Runnable {
    private final Plate plate;

    public Child(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        while (true) {
            E value = (E) plate.get();
            if (value == null) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + " consumes: " + value);
        }
    }
}