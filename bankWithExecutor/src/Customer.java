import java.math.BigDecimal;

public class Customer implements Runnable {
    private String name;
    private String transactionType;
    private BankAccount bankAccount;

    public Customer(String name, String transactionType, BankAccount bankAccount) {
        this.name = name;
        this.transactionType = transactionType;
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        if(transactionType.equals("Deposit")) {
            System.out.println("Deposited " + name);
            bankAccount.deposit(BigDecimal.valueOf(10000));
            System.out.println(name + " deposited, Balance: " + bankAccount.getBalance());
        } else if (transactionType.equals("Withdraw")) {
            System.out.println("Withdrawn " + name);
            bankAccount.withdraw(BigDecimal.valueOf(10000));
            System.out.println(name + " withdrawn, Balance: " + bankAccount.getBalance());
        } else if (transactionType.equals("Check Balance")) {
            System.out.println("Checking Balance " + name);
            System.out.println(name + " balance, Balance: " + bankAccount.getBalance());
        }

    }
}
