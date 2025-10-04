public class Plate {
    private String food = null;

    public Plate(String food) {
        this.food = food;
    }

    public synchronized void produce(String food) {

        while (this.food != null) { // if food is available, the producer should wait
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.food = food;
        notifyAll();
    }

    public synchronized String consume() {
        while (this.food == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String food = this.food;

        this.food = null;
        notifyAll();
        return food;
    }
}
