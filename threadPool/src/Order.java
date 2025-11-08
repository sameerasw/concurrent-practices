import java.util.concurrent.Callable;

public class Order implements Callable<String> {
    private Pizza pizza;

    public Order(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Chef started cookin' " + pizza.getName() + " of size " +  pizza.getSize());
        Thread.sleep(pizza.getTimeToBake() * 1000);

        System.out.println("Chef cooked "  + pizza.getName());
        return pizza.getName() + " is ready";
    }
}
