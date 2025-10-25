public class Mailbox {
    private int mail = -1;

    public synchronized void setMail(int mail) {
        while (this.mail != -1) {
            try {
                wait();
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.mail = mail;
        notifyAll();
    }

    public synchronized int getMail(){
        while (this.mail == -1) {
            try {
                wait();
            }   catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int readMail = this.mail;
        this.mail = -1;
        notifyAll();
        return readMail;
    }
}
