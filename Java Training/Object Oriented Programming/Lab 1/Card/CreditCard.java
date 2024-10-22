public class CreditCard extends Card{
    private int maxCredit;

    public CreditCard(String IBAN, int amount, int maxCredit){
        super(IBAN, amount);
        this.maxCredit = maxCredit;
    }

    @Override
    public void withdraw(int sum){
        if(this.getAmount() + sum < maxCredit){
            System.out.println("Succes!");
            this.setAmount(this.getAmount() + sum);
        }
        else {
            System.out.println("Error!");
        }
    }
}
