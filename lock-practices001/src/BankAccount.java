import java.math.BigDecimal;

public class BankAccount {
    private BigDecimal balance;
    private String accNo;

    public BankAccount(double balance, String accNo){
        this.balance = new BigDecimal(balance);
        this.accNo = accNo;
    }

    public synchronized double getBalance() {
        return balance.doubleValue();
    }

    public synchronized void deposit(double amount){
        if (amount > 0){
            this.balance.add(new BigDecimal(amount));
            System.out.println("Deposited " + amount + " " + Thread.currentThread().getName());
        } else {
            System.out.println("Amount is negative");
        }
    }

    public synchronized void withdraw(double amount){
        if (amount > 0 && this.balance.intValue() > 0){
            this.balance.subtract(new BigDecimal(amount));
            System.out.println("Withdrawn " + amount + " " + Thread.currentThread().getName());
        }  else {
            System.out.println("Insufficient Balance");
        }
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }
}
