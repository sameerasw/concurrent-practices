public class BalanceChecker implements Runnable {
    private BankAccount bankAccount;

    public BalanceChecker(BankAccount account) {
        this.bankAccount = account;
    }

    @Override
    public void run() {
        System.out.println(bankAccount.getBalance());
    }
}
