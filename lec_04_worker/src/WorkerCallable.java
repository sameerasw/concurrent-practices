import java.util.concurrent.Callable;

public class WorkerCallable implements Callable<Integer> {
    private int start;
    private int end;

    public WorkerCallable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws InterruptedException {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}
