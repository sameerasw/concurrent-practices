void main() throws ExecutionException, InterruptedException {

    Pizza pizza1 = new Pizza("Margherita", 12, 5);
    Pizza pizza2 = new Pizza("Pepper", 15, 15);
    Pizza pizza3 = new Pizza("PineApple", 10, 7);
    Pizza pizza4 = new Pizza("Hawaiian", 8, 5);
    Pizza pizza5 = new Pizza("Sausage", 12, 5);

    List<Pizza> pizzas = Arrays.asList(pizza1, pizza2, pizza3, pizza4, pizza5);

    ExecutorService executor = Executors.newFixedThreadPool(3);

    List<Future<String>> futures = new ArrayList<>();

    for(Pizza pizza : pizzas) {
        Future<String> future = executor.submit(new Order(pizza));
        futures.add(future);
        // because future.get() blocks thread making it sequential,
        // we store them in a list and later manually access them in a loop
    }

    for (Future<String> future : futures) {
        System.out.println(future.get());
    }

    executor.shutdown();
}