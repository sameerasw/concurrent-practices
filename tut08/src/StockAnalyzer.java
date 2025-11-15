import java.util.*;
import java.util.concurrent.*;

public class StockAnalyzer {
    public static void main(String[] args) throws Exception {
//        ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorService executor = Executors.newSingleThreadExecutor();

        List<Callable<Double>> tasks = Arrays.asList(
                new StockPriceFetcher("Yahoo Finance", "AAPL"),
                new StockPriceFetcher("Google Finance", "AAPL"),
                new StockPriceFetcher("Bloomberg", "AAPL")
        );


            List<Future<Double>> results = executor.invokeAll(tasks, 2, TimeUnit.SECONDS);

            double total = 0;
            int success = 0;

            for (Future<Double> result : results) {

                try {
                    total += result.get(2, TimeUnit.SECONDS);
                    success++;
                } catch (CancellationException _) {
                    System.out.println("Network timeout");
                }
            }

            System.out.println("Average Stock Price: " + (total / success) + " from results: " + success);


        executor.shutdown();
    }
}