public class Mother implements Runnable {
    private final Plate plate;

    public Mother(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            plate.put("food " + i);
            System.out.println(Thread.currentThread().getName() + " serves: " + "food " + i);
        }
    }
}