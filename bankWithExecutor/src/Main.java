void main(){
    BankAccount bankAccount = new BankAccount(BigDecimal.valueOf(10000));

    Customer[] customers = {
            new Customer("person1", "Deposit", bankAccount),
            new Customer("person2", "Withdraw", bankAccount),
            new Customer("person3", "Deposit", bankAccount),
            new Customer("person4", "Withdraw", bankAccount),
            new Customer("person5", "Deposit", bankAccount),
    };

    ExecutorService executor = Executors.newSingleThreadExecutor();

    for (Customer customer : customers){
        executor.submit(customer);
    }

    executor.shutdown();

    while (!executor.isTerminated()){

    }

    System.out.println("Transactions completed successfully, final balance: " + bankAccount.getBalance());
}