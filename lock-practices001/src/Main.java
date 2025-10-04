void main() {
    BankAccount bankAccount = new BankAccount(0, "123");

    Runnable wife = new CMW(bankAccount);
    Runnable husband = new HBH(bankAccount);

    Thread wifeThread = new Thread(wife, "wife");
    Thread husbandThread = new Thread(husband, "husband");

    wifeThread.start();
    husbandThread.start();
}