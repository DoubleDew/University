package Card;
public class CardDriver {
    public static void main(String args[]) {
        DebitCard card1 = new DebitCard("BCR", 15000);
        CreditCard card2 = new CreditCard("ING", 20000, 50000);

        System.out.println("Debit card amount is: " + card1.getAmount());
        card1.withdraw(4000);
        System.out.println("New debit card amount is: " + card1.getAmount());
        
        card1.withdraw(100000);

        System.out.println("Credit card amount is: " + card2.getAmount());
        card2.withdraw(5000);
        System.out.println("New credit card amount is: " + card2.getAmount());
        
        card2.withdraw(50000);
    }
}
