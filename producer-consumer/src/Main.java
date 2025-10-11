void main() throws InterruptedException {
    Plate plate = new Plate(null);

    Runnable mom = new Mother(plate);
    Runnable child = new Child(plate);

    Thread momThread = new Thread(mom, "mom");
    Thread childThread = new Thread(child, "child");

    momThread.start();
    childThread.start();

    momThread.join(); // Puts main to WAITING state until the called thread TERMINATE/ Completes it's run()

    System.out.println("Producer completes execution");

    childThread.join();

    System.out.println("Consumer completes execution");

    System.out.println("ALL DONE");
}
