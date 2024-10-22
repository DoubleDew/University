package Card;

public class CreditAccount extends Account{
    private int maxCredit;

    public CreditAccount(String IBAN, int amount, int maxCredit){
        super(IBAN, amount);
        this.maxCredit = maxCredit;
    }

    @Override
    public boolean withdraw(int amount){
        if(this.getAmount() + amount < maxCredit){
            this.setAmount(this.getAmount() + amount);
            return true;
        }
        else 
            return false;
    }

    @Override
    public void deposit(int amount){
        if(this.getAmount() + amount < maxCredit){
            this.setAmount(this.getAmount() - amount);
            System.out.println("Amount added succesfully! New credit card amount: " + getAmount());
        }
        else {
            System.out.println("Error! Amount deposited exceeds max credit!");
        }
    }
    
}
