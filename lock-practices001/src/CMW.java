public class CMW implements Runnable{
        private BankAccount bankAccount;

        public CMW(BankAccount bankAccount) {
            this.bankAccount = bankAccount;
        }


        public void run() {
            for (int i = 1; i <= 10; i++) {
                this.bankAccount.deposit(25000);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }

}
