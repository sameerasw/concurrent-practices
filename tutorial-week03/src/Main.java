void main() {

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

    Mailbox mailbox = new Mailbox();

    Runnable producer = new Producer(mailbox);
    Runnable consumer = new Consumer(mailbox);

    Thread producerThread = new Thread(producer, "Producer");
    Thread consumerThread = new Thread(consumer, "Consumer");

    producerThread.start();
    consumerThread.start();
}
