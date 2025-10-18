void main() {
    final int capacity = 5;
    final int numberOfCustomers = 5;
    final int numberOfBarista = 2;

    CoffeeShop coffeeShop = new CoffeeShop(capacity);

    Thread[] customer = new Thread[numberOfCustomers];
    Thread[] barista = new Thread[numberOfBarista];

    for (int i = 0; i < numberOfCustomers; i++) {
        customer[i] = new Thread(new Customer(coffeeShop), "Customer " + i);
    }

    for (int i = 0; i < numberOfBarista; i++) {
        barista[i] = new Thread(new Barista(coffeeShop), "Barista " + i);
    }

    for (Thread thread : customer ) {
        thread.start();
    }

    for (Thread thread : barista ) {
        thread.start();
    }
}
