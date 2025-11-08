void main(){

    ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(5),
            new CustomFactory(),
            new CustomRejectionPolicy()
    );

    executor.allowCoreThreadTimeOut(true); // needs to be true for DiscardPolicy

    for(int i = 0; i < 50; i++){
        executor.submit(new Example());
    }

    executor.shutdown();
}