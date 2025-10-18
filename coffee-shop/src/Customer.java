import java.util.Random;

public class Customer implements Runnable {
    private CoffeeShop coffeeShop;

    public Customer(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;

    }

    @Override
    public void run() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int orderNumber = random.nextInt(5) + 1;
        coffeeShop.placeOrder(String.valueOf(orderNumber));
        System.out.println("Order placed: " + orderNumber + " by: "  + Thread.currentThread().getName() + " & order: " + orderNumber);
    }
}
