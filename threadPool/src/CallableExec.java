void main() throws ExecutionException, InterruptedException {
    ExecutorService executor = Executors.newSingleThreadExecutor();

    Future<Integer> future = executor.submit(new MyCallable());

    System.out.println(future.get());

    executor.shutdown();
}