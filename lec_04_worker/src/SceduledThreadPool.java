void main() {
    ScheduledExecutorService executor =  Executors.newScheduledThreadPool(2);
    // core pool size is 2 means, at least 2 threads will be kept alive in the pool
    // if the demand increases, more threads will be created beyond the corePoolSize.

    System.out.println("Executor has been scheduled");

    WorkerThread2 workerThread1 = new WorkerThread2(1, 11, "worker1");

    executor.scheduleAtFixedRate(workerThread1, 3, 1, TimeUnit.SECONDS);
//    The worker thread will be performed after a 3-second initial delay
//    After that, the worker thread will be executed at a fixed rate of every 1 second irrespective of if previous task is completed or not.


    executor.scheduleWithFixedDelay(workerThread1, 2, 2, TimeUnit.SECONDS);
//    The worker thread will be started after the initial delay of 2 seconds.
//    After that, the worker threads will be executed one by one with a 2-second delay in-between the end of the previous task and the start of the next one.
//    The delay will be between the end of the previous task and the start of the next task.

}