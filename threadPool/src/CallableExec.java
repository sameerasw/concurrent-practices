void main() throws ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newSingleThreadExecutor();

    Future future = executor.submit(new MyCallable());

    System.out.println(future.get());

    executor.shutdown();
}