public abstract class Card {
    private String IBAN;
    private int amount;

    public Card(String iban, int amount){
        this.IBAN = iban;
        this.amount = amount;
    }

    public abstract void withdraw(int sum);

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
