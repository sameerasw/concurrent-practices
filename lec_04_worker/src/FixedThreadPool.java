void main() {
    ExecutorService executor =  Executors.newFixedThreadPool(20);
//    Here, we are currently creating a threadPool with active 3 threads.

    for (int i = 0; i <= 100; i++){
        WorkerThread2 workerThread = new WorkerThread2(1, 11, "worker" + i);
        executor.submit(workerThread);
//        We are creating the runnable tasks and submitting those tasks to the thread in the threadPool
//        If there are active threads available in the pool, those tasks will be assigned to the active threads in the pool.
//        If there are no active threads available, then these tasks will be added to an unbounded queue.
//        As soon as an active thread become available, it will pick the tasks in the queue.
    }

    executor.shutdown(); // no new tasks to be executed but existing tasks will complete.

    while(!executor.isTerminated()) {
//        System.out.println("Waiting for tasks to finish");
    }
    System.out.println("Executor has been terminated");
}