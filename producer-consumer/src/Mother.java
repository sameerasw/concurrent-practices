public class Mother implements Runnable {
    private final Plate plate;
    private final int noOfServings;

    public Mother( Plate plate, int noOfServings ) {
        this.plate = plate;
        this.noOfServings = noOfServings;
    }

    @Override
    public void run() {
        for (int i = 0; i < noOfServings; i++) {
            plate.produce("food");
            System.out.println(Thread.currentThread().getName() + " produced food " + i);
        }
    }

}
