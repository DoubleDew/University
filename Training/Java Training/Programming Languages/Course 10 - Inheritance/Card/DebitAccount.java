package Card;

public class DebitAccount extends Account{
    public DebitAccount(String IBAN, int amount){
        super(IBAN, amount);
    }

    @Override
    public boolean withdraw(int amount){
        
        if(this.getAmount() >= amount){
            this.setAmount(this.getAmount() - amount);
            return true;
        }
        else
            return false;
    }

    @Override
    public void deposit(int amount){
        this.setAmount(this.getAmount() + amount);
    }
}
