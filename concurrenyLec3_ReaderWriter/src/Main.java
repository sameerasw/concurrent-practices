void main() {

    BankAccount bankAccount = new BankAccount("1234", BigDecimal.valueOf(0));
    // This is a monitor object
    // Only one writer thread can access the write method at once while there's no reader
    // There can be any number of threads accessing the read methods as long as there's no writer methods.

    CMW cmw = new CMW(bankAccount);
    HBH hbh = new HBH(bankAccount);
    BalanceChecker balanceChecker = new BalanceChecker(bankAccount);
    // All three threads are sharing the same bank account (monitor object) object.

    Thread cmwThread = new Thread(cmw, "cmw");
    System.out.println("cmw thread state: " + cmwThread.getState());
    Thread hbhThread = new Thread(hbh, "hbh");
    System.out.println("hbh thread state: " + hbhThread.getState());
    Thread balanceCheckerThread = new Thread(balanceChecker, "balanceChecker");
    System.out.println("balanceChecker thread state: " + balanceCheckerThread.getState());

    cmwThread.start();
    System.out.println("cmw thread state: " + cmwThread.getState());
    hbhThread.start();
    System.out.println("hbh thread state: " + hbhThread.getState());
    balanceCheckerThread.start();
    System.out.println("balance checker thread state: " + balanceCheckerThread.getState());

    
}
