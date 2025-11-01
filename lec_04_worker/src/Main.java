void main() throws InterruptedException, ExecutionException {
    Runnable workerThread = new WorkerThread(1, 10);

    Thread calc = new Thread(workerThread, "calc");

    calc.start();
//    calc.join(3000);

//    try{
//        wait(3000);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }

//    System.out.println(calc.getSum());

//    -------

    ExecutorService executor = Executors.newSingleThreadExecutor();

    Future<Integer> future = executor.submit(new WorkerCallable(1,100));

    if (!future.isDone()) { // future is done, a non-blocking way to check if work is completed
        System.out.println("Calculating...");
    }

    int result = future.get(); // Blocks until the work is done (execution is done)
    System.out.println("Result : " + result);



}
