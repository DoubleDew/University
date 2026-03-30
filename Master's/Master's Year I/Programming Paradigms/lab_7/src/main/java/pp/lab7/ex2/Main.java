package pp.lab7.ex2;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        for (int i = 1; i <= 3; i++) {
            Thread depositThread = new Thread(new Deposit(account, 300, 4, 200 ));
            depositThread.setName("Deposit-" + i);
            depositThread.start();
        }

        for (int i = 1; i <= 3; i++) {
            Thread withdrawThread = new Thread(new Withdraw(account, 150, 6, 300));
            withdrawThread.setName("Withdraw-" + i);
            withdrawThread.start();
        }
    }
}
