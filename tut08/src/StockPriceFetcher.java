import java.util.concurrent.Callable;

public class StockPriceFetcher implements Callable<Double> {
    private final String apiName;
    private final String stockSymbol;

    public StockPriceFetcher(String apiName, String stockSymbol) {
        this.apiName = apiName;
        this.stockSymbol = stockSymbol;
    }

    @Override
    public Double call() throws Exception {

        System.out.println("Fetching price from " + apiName + "...");

        Thread.sleep((int)(Math.random() * 2000) + 1000); // simulate delay

        double price = 100 + Math.random() * 50; // random price

        System.out.println(apiName + " returned: " + price);

        return price;
    }
}