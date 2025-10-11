void main() throws InterruptedException {
//    Plate plate = new SingleSlotPlate(null);
    Plate plate = new MultiSlotPlate(2);

    int noOfProducers = 5;
    int noOfConsumers = 5;

    Thread[] producers = new Thread[noOfProducers];
    Thread[] consumers = new Thread[noOfConsumers];

    for (int i = 0; i < noOfProducers; i++) {
        producers[i] = new Thread(new Mother(plate), "Producer-" + i);
    }

    for (int i = 0; i < noOfConsumers; i++) {
        consumers[i] = new Thread(new Mother(plate), "Consumer-" + i);
    }

    System.out.println("Starting producer threads");
    for(Thread producer : producers) {
        producer.start();
    }

    System.out.println("Starting consumer threads");
    for(Thread consumer : consumers) {
        consumer.start();
    }

    for(Thread producer : producers) {
        producer.join();
    }

    for(Thread consumer : consumers) {
        consumer.join();
    }

//    Runnable mom = new Mother(plate);
//    Runnable child = new Child(plate);
//
//    Thread momThread = new Thread(mom, "mom");
//    Thread childThread = new Thread(child, "child");
//
//    momThread.start();
//    childThread.start();

//    momThread.join(); // Puts main to WAITING state until the called thread TERMINATE/ Completes it's run()

//    System.out.println("Producer(s) completes execution");

//    childThread.join();

//    System.out.println("Consumer(s) completes execution");

    System.out.println("ALL DONE");
}
