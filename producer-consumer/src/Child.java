import java.util.Objects;

public class Child implements Runnable {
    private final Plate plate;

    public Child(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        while (true) {
            String value = plate.consume();
            if (Objects.equals(value, "poison")) {
                break; // poison pill kills
            }
//            plate.consume();
            System.out.println(Thread.currentThread().getName() + " consumed " + value);
        }
    }
}
