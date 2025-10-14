package Card;
public class DebitCard extends Card{
    // We use the super keyword to call the constructor of the parent class.
    // In other words, we do not need to add new variables and its constructor in this class.
    public DebitCard(String bank, int amount) {
        super(bank, amount);
    }


    // Because we have the CardIF interface, we need to implement the withdraw method with @Override.
    @Override
    public void withdraw(int sum) {
        if(this.getAmount() < sum)
            System.out.println("Insufficient funds.");
        else
        {
            this.setAmount(this.getAmount() - sum);
            System.out.println("Succes!");
        }
    }
}
