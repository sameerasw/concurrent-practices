public class Mother implements Runnable {
    private final Plate plate;

    public Mother( Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            plate.produce("food");
            System.out.println(Thread.currentThread().getName() + " produced food " + i);
        }
        plate.produce("poison"); // poison pill
    }

}
