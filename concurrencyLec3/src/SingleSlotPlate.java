public class SingleSlotPlate implements Plate { // Plate is shared resource
    private String food = null;  // Shared variable

    /**
     * Producer calls this method.
     * Waits if plate is full (this.food != null).
     */
    @Override
    public synchronized void put(String food) {
        while (this.food != null) {   // if the food is available the producer should wait until the plate becomes empty
            try {
                wait();  // RUNNABLE → WAITING (releases lock!)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Plate is empty, put item
        this.food = food;
        // Wake up waiting consumers
        notifyAll();  // WAITING → RUNNABLE
    }

    /**
     * Consumer calls this method.
     * Waits if plate is empty (this.food == null).
     */
    @Override
    public synchronized String get() {
        // CRITICAL: Use while, not if
        while (this.food == null) {
            try {
                wait();  // RUNNABLE → WAITING (releases lock!)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String food = this.food;    // Plate has data, consume it
        this.food = null;  // Set the food to null
        // Wake up waiting producers
        notifyAll();  // WAITING → RUNNABLE
        return food;
    }
}