import java.util.concurrent.ThreadFactory;

public class CustomFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "CustomFactory");
        t.setPriority(Thread.NORM_PRIORITY);
        t.setDaemon(false);

        return t;
    }
}
