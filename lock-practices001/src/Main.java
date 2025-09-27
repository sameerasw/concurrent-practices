//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(0,"123");

        Runnable wife = new CMW(bankAccount);
        Runnable husband = new HBH(bankAccount);

        Thread wifeThread = new Thread(wife, "wife");
        Thread husbandThread = new Thread(husband,  "husband");

        wifeThread.start();
        husbandThread.start();
    }
}