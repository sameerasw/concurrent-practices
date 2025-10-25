public class Consumer implements Runnable {
    private Mailbox mailbox;

    public Consumer(Mailbox mailbox) {
        this.mailbox = mailbox;
    }

    @Override
    public void run() {
        while (true) {
            int gotMail = mailbox.getMail();
            System.out.println(Thread.currentThread().getName() + " get mail " + gotMail);
            if(gotMail == 10){
                break;
            }
        }
    }
}
