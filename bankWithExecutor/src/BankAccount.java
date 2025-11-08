import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    BigDecimal balance;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        lock.readLock().lock();
        try {
            return balance;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void deposit(BigDecimal balance) {
        lock.writeLock().lock();
        try {
            this.balance = balance;
        }  finally {
            lock.writeLock().unlock();
        }
    }

    public void withdraw(BigDecimal balance) {
        lock.writeLock().lock();
        try {
            if (balance.compareTo(balance) < 0) {
                this.balance = balance;
            }
        }   finally {
            lock.writeLock().unlock();
        }
    }
}
