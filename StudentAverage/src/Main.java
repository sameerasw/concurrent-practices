void main() throws InterruptedException, ExecutionException {
    Student student1 = new Student(001, "John Doe", new int[] {50,68,38});
    Student student2 = new Student(002, "Alex Jake", new int[] {35,67,89});
    Student student3 = new Student(003, "Jack Max",  new int[] {45,67,23});

    List<Student> students = Arrays.asList(student1, student2, student3);

    ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.DiscardPolicy());

    List<Future<Double>> futureList = new ArrayList<>();

    List<Callable<Double>> callables = new ArrayList<>();

    for (Student student : students) {
        callables.add(new AverageCalculator(student));
    }

    futureList = executor.invokeAll(callables);

    for (Future<Double> future : futureList) {
            System.out.println("Average is : " + future.get());
    }



//    for (Student student : students) {
//        futureList.add(executor.submit(new AverageCalculator(student)));
//    }

//    for (Future<Double> future : futureList) {
//        try {
//            System.out.println("Average is : " + future.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//    }

    executor.shutdown();
}
