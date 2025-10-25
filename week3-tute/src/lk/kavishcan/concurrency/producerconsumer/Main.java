import lk.kavishcan.concurrency.producerconsumer.Consumer;
import lk.kavishcan.concurrency.producerconsumer.Mailbox;
import lk.kavishcan.concurrency.producerconsumer.Producer;

void main() {
    int noOfProducers = 3;
    int noOfConsumers = 3;
    int mailboxCapacity = 5;
    Mailbox box = new Mailbox(mailboxCapacity);

    Thread[] producer = new Thread[noOfProducers];
    Thread[] consumer = new Thread[noOfConsumers];

    for (int i = 0; i < noOfProducers; i++) {
        producer[i] = new Thread(new Producer(box), "Producer-" + (i + 1));
    }

    for (int i = 0; i < noOfConsumers; i++) {
        consumer[i] = new Thread(new Consumer(box), "Consumer-" + (i + 1));
    }

    for (Thread p: producer){
        p.start();
    }

    for (Thread c: consumer){
        c.start();
    }

    for (Thread p: producer){
        try {
            p.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    System.out.println("====================All Production Over====================");

    for (Thread c: consumer) {
        try {
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    System.out.println("====================All Consumption Over====================");

    System.out.println("====================All done====================");

}
