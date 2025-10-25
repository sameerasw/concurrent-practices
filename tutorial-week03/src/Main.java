void main() {

//    Q1 Threads

//    Runnable counter1 = new Counter();
//    Runnable counter2 = new Counter();
//    Runnable counter3 = new Counter();
//
//    Thread counter1thread = new Thread(counter1, "counter1");
//    Thread counter2thread = new Thread(counter2, "counter2");
//    Thread counter3thread = new Thread(counter3, "counter3");
//
//    counter1thread.start();
//    counter2thread.start();
//    counter3thread.start();

//    Q2 producer consumer

//    Mailbox mailbox = new Mailbox();
//
//    Runnable producer = new Producer(mailbox);
//    Runnable consumer = new Consumer(mailbox);
//
//    Thread producerThread = new Thread(producer, "Producer");
//    Thread consumerThread = new Thread(consumer, "Consumer");
//
//    producerThread.start();
//    consumerThread.start();

//    Q3 Reader writer

    Inventory inv = new Inventory();
    Thread writer = new Thread(() -> {
        for (int i = 0; i < 5; i++)
            inv.updateStock("Manager", (i % 2 == 0 ? +10 : -5));
    });
    for (int i = 1; i <= 3; i++) {
        final int id = i;
        new Thread(() -> {
            for (int j = 0; j < 10; j++)
                inv.readStock("Customer-" + id);
        }).start();
    }
    writer.start();
}
