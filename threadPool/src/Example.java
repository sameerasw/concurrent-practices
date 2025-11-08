public class Example implements Runnable {


    @Override
    public void run() {
        for (int i = 2; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " Executing task " + i);
        }
    }
}
