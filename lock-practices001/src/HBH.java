public class HBH implements Runnable {
    private BankAccount bankAccount;

    public HBH(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            this.bankAccount.withdraw(25000);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
