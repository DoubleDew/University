package pp.lab7.ex2;

public class Withdraw implements Runnable{
    private final BankAccount account;
    private final long amountWithdraw;
    private final int repetitions;
    private final long delayMillis;

    public Withdraw(BankAccount account, long amountWithdraw, int repetitions, long delayMillis) {
        this.account = account;
        this.amountWithdraw = amountWithdraw;
        this.repetitions = repetitions;
        this.delayMillis = delayMillis;
    }

    @Override
    public void run() {
        for(int i = 0; i < repetitions; i++){
            account.withdraw(amountWithdraw);
            try{
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
