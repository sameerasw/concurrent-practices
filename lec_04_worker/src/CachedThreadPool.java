void main() {
    ExecutorService executor = Executors.newCachedThreadPool();


    for (int i = 0; i <= 100000000; i++){
        WorkerThread2 workerThread = new WorkerThread2(1, 11, "worker" + i);
        executor.submit(workerThread);
    }

    executor.shutdown();

    while(!executor.isTerminated()) {
//        System.out.println("Waiting for tasks to finish");
    }
    System.out.println("Executor has been terminated");
}