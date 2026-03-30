package pp.lab7.ex2;

public class Deposit implements Runnable{
    private final BankAccount account;
    private final long amountDeposit;
    private final int repetitions;
    private final long delayMillis;

    public Deposit(BankAccount account, long amountDeposit, int repetitions, long delayMillis) {
        this.account = account;
        this.amountDeposit = amountDeposit;
        this.repetitions = repetitions;
        this.delayMillis = delayMillis;
    }

    @Override
    public void run() {
        for(int i = 0; i < repetitions; i++){
            account.deposit(amountDeposit);
            try{
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
