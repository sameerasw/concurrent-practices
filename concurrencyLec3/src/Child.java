public class Child implements Runnable {
    private final Plate plate;

    public Child(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        while (true) {
            String value = plate.get();
            if (value == null) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + " consumes: " + value);
        }
    }
}