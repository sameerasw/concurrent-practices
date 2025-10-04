public class Child implements Runnable {
    private final Plate plate;
    private int noOfServings;

    public Child(Plate plate,  int noOfServings) {
        this.plate = plate;
        this.noOfServings = noOfServings;
    }

    @Override
    public void run() {
        for (int i = 0; i < noOfServings; i++) {
            plate.consume();
            System.out.println(Thread.currentThread().getName() + " consumed food " + i);
        }
    }
}
