package Card;

public abstract class Account {
    private String IBAN;
    private int amount;
    
    public Account(String iban, int amount){
        this.IBAN = iban;
        this.amount = amount;
    }

    public abstract boolean withdraw(int amount);

    public abstract void deposit(int amount);

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String iBAN) {
        IBAN = iBAN;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    
}

