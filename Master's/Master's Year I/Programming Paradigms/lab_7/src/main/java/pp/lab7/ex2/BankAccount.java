package pp.lab7.ex2;

public class BankAccount {
    private long balance;

    public BankAccount(long initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(long amountDeposit) {
        if (amountDeposit <= 0)
            return;
        balance += amountDeposit;

        System.out.printf("%s deposited %d -> balance = %d%n",
                Thread.currentThread().getName(), amountDeposit, balance);
    }

    public synchronized boolean withdraw(long amountWithdraw) {
        if (amountWithdraw <= 0) 
            return false;

        if (balance < amountWithdraw) {
            System.out.printf("%s failed withdraw %d (insufficient) -> balance = %d%n",
                    Thread.currentThread().getName(), amountWithdraw, balance);
            return false;
        }

        balance -= amountWithdraw;
        System.out.printf("%s withdrew %d -> balance = %d%n",
                Thread.currentThread().getName(), amountWithdraw, balance);
        return true;
    }

    public synchronized long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Balance: " + balance;
    }
}