void main() {
    Employee employee1 = new Employee("Employee1", 1234, 20000, 5);
    Employee employee2 = new Employee("Employee2", 1235, 10000, 3);
    Employee employee3 = new Employee("Employee3", 1236, 30000, 4);
    Employee employee4 = new Employee("Employee4", 1237, 15000, 3);
    Employee employee5 = new Employee("Employee5", 1238, 12000, 4);

    List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5);

//    ExecutorService executor = Executors.newSingleThreadExecutor();

//    ExecutorService executor = Executors.newFixedThreadPool(2);

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);


//    for (Employee employee : employees) {
//        executor.submit(new SalaryCal(employee));
//    }

//    executor.shutdown();


    for (Employee employee : employees) {
        scheduler.schedule(new SalaryCal(employee), 3,  TimeUnit.SECONDS);
    }

    scheduler.shutdown();

}
