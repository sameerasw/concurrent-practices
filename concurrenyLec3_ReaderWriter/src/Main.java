void main() throws InterruptedException {

    BankAccount bankAccount = new BankAccount("1234", BigDecimal.valueOf(50000));
    // This is a monitor object
    // Only one writer thread can access the write method at once while there's no reader
    // There can be any number of threads accessing the read methods as long as there's no writer methods.

    CMW cmw = new CMW(bankAccount);
    HBH hbh = new HBH(bankAccount);
    BalanceChecker balanceChecker = new BalanceChecker(bankAccount);
    // All three threads are sharing the same bank account (monitor object) object.

    

    Thread balanceCheckerThread = new Thread(balanceChecker, "balanceChecker");
    System.out.println("balanceChecker thread state: " + balanceCheckerThread.getState());

    balanceCheckerThread.start();
    System.out.println("balance checker thread state: " + balanceCheckerThread.getState());

    balanceCheckerThread.join();
    // after calling join(), the Main thread goes into WAITING until the run() is completed.
    System.out.println("balance checker thread state: " + balanceCheckerThread.getState());

    //    ---------

    Thread cmwThread = new Thread(cmw, "cmw");
    System.out.println("cmw thread state: " + cmwThread.getState());

    cmwThread.start();
    System.out.println("cmw thread state: " + cmwThread.getState());

    cmwThread.join();

    //    --------

    Thread balanceChecker2 = new Thread(balanceChecker, "balanceChecker2");
    System.out.println("balanceChecker2 thread state: " + balanceChecker2.getState());

    balanceChecker2.start();
    System.out.println("balance checker 2 thread state: " + balanceChecker2.getState());

    balanceChecker2.join();

    //     ---------

    Thread hbhThread = new Thread(hbh, "hbh");
    System.out.println("hbh thread state: " + hbhThread.getState());

    hbhThread.start();
    System.out.println("hbh thread state: " + hbhThread.getState());

    hbhThread.join();

    //      --------

    Thread balanceChecker3 = new Thread(balanceChecker, "balanceChecker2");
    System.out.println("balanceChecker2 thread state: " + balanceChecker3.getState());

    balanceChecker3.start();
    System.out.println("balance checker 2 thread state: " + balanceChecker3.getState());

    balanceChecker3.join();

}
