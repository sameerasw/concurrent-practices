public class Barista implements Runnable {
    private CoffeeShop coffeeShop;

    public Barista(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run() {
        coffeeShop.takeOrder();
        System.out.println("barista processed the order");
    }
}
