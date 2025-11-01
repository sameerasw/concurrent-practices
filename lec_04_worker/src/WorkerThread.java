public class WorkerThread implements Runnable {
    private int start;
    private int end;
    private int sum;

    public  WorkerThread(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
    }

    public int getSum(){
        return sum;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            sum += i;
        }
    }
}
