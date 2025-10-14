package Card;
public class CreditCard extends Card{
    private int maxCredit;
    public CreditCard(String bank, int amount, int maxCredit){
        super(bank, amount);
        this.maxCredit = maxCredit;
    }

    @Override
    public void withdraw(int sum){
        if(this.getAmount() + sum > maxCredit)
            System.out.println("Error!");
        else
        {
            this.setAmount(this.getAmount() + sum);
            System.out.println("Succes!");
        }
    }

    public int getMaxCredit(){
        return maxCredit;
    }

    public void setMaxCredit(int maxCredit){
        this.maxCredit = maxCredit;
    }
}
