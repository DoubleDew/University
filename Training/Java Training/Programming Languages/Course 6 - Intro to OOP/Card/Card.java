package Card;
public abstract class Card implements CardIF{
    private String bank;
    private int amount;

    // Because class Card implements the CardIF interface, we need to implement the withdraw method.
    // public abstract void withdraw(int sum);

    public Card(String bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }
    
    ///
    /// Insert other methods here. Also, what is above and below this comment block is a template for a class.
    ///

    // I will automatically add the getters and setters because I'm lazy but what you need to remember is that
    // getters HAVE a return type and setters DON'T have a return type. Setters have the "this.something = something" structure.
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String toString(){
        return this.bank + " " + this.amount;
    }

}
