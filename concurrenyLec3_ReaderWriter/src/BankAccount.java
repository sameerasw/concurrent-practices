
import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// this is the monitor class
public class BankAccount {
    private String accountNumber;
    private BigDecimal balance; // shared variable
    // we want to have multiple read operations while not writing
    // one writer while 0 reader
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock(); // for read operation
    private final Lock writeLock = lock.writeLock(); // for write operation

    public BankAccount(String accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // reader method
    public BigDecimal getBalance() {
        try{
            readLock.lock();
            return balance;
        } finally {
            readLock.unlock();
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // writer method
    public void withdraw(BigDecimal amount) {
        try{
            writeLock.lock();

            if (amount.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("Amount cannot be negative");
            }

            if (amount.compareTo(balance) > 0) {
                throw new IllegalArgumentException("Amount can not be greater than balance");
            }

            balance = balance.subtract(amount);
        } finally {
            writeLock.unlock();
        }
    }

    // writer method
    public void deposit(BigDecimal amount) {
        try {
            writeLock.lock();
            if (amount.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("Amount cannot be negative");
            }

            balance = balance.add(amount);
        } finally {
            writeLock.unlock();
        }
    }
}
