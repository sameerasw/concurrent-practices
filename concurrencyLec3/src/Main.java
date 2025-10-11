void main(){
    Plate plate = new SingleSlotPlate();
    plate = new MultiSlotPlate(4);

    int noOfProducer = 5;
    int noOfConsumer = 2;

    Thread[] producers = new Thread[noOfProducer];
    Thread[] consumers = new Thread[noOfConsumer];

    for (int i = 0; i < noOfProducer; i++) {
        producers[i] = new Thread(new Mother(plate), "Mother " + i );
    }

    for (int i = 0; i < noOfConsumer; i++) {
        consumers[i] = new Thread(new Child(plate), "Child " + i);
    }

//    Thread producer = new Thread(new Mother(plate), "Mother");
//    Thread consumer = new Thread(new Child(plate), "Child");

    System.out.println("=== Starting Producer-Consumer (Synchronized) ===\n");

    for(Thread producer : producers){
        producer.start();
    }

    for(Thread consumer : consumers){
        consumer.start();
    }

    try {
        for (Thread producer : producers) {
            producer.join(); // the main thread calls the join on producer
        }
        // therefore the main thread goes into the WAITING state until the producer thread dies down
        // The thread which calls the join method goes into the WAITING state until the thread on which join method is called is TERMINATED
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("\nThe producer is done");

//    for (int i = 0 ; i < noOfConsumer; i++) {
//        plate.put("poison pill"); // poison pill
//    }

    ((MultiSlotPlate) plate).close();

    try {
        for (Thread consumer : consumers) {
            consumer.join(); // the main thread calls the join on consumer
        }
        // therefore the main thread goes into the WAITING state until the consumer thread dies down
        // The thread which calls the join method goes into the WAITING state until the thread on which join method is called is TERMINATED
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("\nThe consumer is done");

    System.out.println("\n=== All Done ===");
}
