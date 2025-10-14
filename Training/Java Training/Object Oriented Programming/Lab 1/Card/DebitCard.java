public class DebitCard extends Card{
    public DebitCard(String IBAN, int amount){
        super(IBAN, amount);
    }

    @Override
    public void withdraw(int sum){
        if(this.getAmount() >= sum ){
            System.out.println("Succes!");
            this.setAmount(this.getAmount() - sum);
        }
        else {
            System.out.println("Error!");
        }
    }
}
