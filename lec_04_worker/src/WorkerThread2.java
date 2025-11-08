public class WorkerThread2 implements Runnable {
    private int start;
    private int end;
    private int sum;
    private String name;

    public WorkerThread2(int start, int end, String name) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.sum = 0;
    }

    public int getSum(){
        return sum;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(name + " processing: " + i);
            sum += i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println( name + " : sum = " + sum);
    }
}
