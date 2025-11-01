void main() {
    Thread[] workerThreads = new Thread[100000000];
//    A single thread will take 500kb - 1mb memory or more.
    // 100000000 will take around 512 000 000kb - 1000 000MB which is around 512TB

    for (int i = 0; i < workerThreads.length; i++) {
        workerThreads[i] = new Thread(new WorkerThread2(1, 11, "worker1"), "thread" + i);
    }

    for (int i = 0; i < workerThreads.length; i++) {
        workerThreads[i].start();
    }
}