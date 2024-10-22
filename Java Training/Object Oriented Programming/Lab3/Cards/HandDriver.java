import java.io.FileNotFoundException;

public class HandDriver {
    
    public static void main(String[] args) throws FileNotFoundException{
        Hand h = new Hand();

        // adding cards
        System.out.println("Adding cards to hand...");
        h.addCard(new Card(Card.Rank.ACE, Card.Suit.HEARTS));
        h.addCard(new Card(Card.Rank.TWO, Card.Suit.DIAMONDS));
        h.addCard(new Card(Card.Rank.FOUR, Card.Suit.SPADES));
        h.addCard(new Card(Card.Rank.THREE, Card.Suit.DIAMONDS));
        h.addCard(new Card(Card.Rank.SIX, Card.Suit.CLUBS));
        h.addCard(new Card(Card.Rank.FIVE, Card.Suit.DIAMONDS));
        h.addCard(new Card(Card.Rank.TWO, Card.Suit.CLUBS));

        // displaying the hand unsorted
        System.out.println();
        System.out.println("New hand contains: ");
        h.display();

        // deleting a card
        System.out.println();
        System.out.println("Deleting card: TWO of CLUBS");
        System.out.println(h.deleteCard(Card.Rank.TWO, Card.Suit.CLUBS));

        // displaying new hand
        System.out.println();
        System.out.println("New hand contains: ");
        h.display();

        // sorting the hand
        System.out.println();
        System.out.println("Sorting hand...");
        h.sort();

        // displaying the hand sorted
        System.out.println();
        System.out.println("Sorted hand contains: ");
        h.display();

        // adding a card that already exists to test exception
        // System.out.println();
        // System.out.println("Adding a card that already exists to test exception...");
        // h.addCard(new Card(Card.Rank.FOUR, Card.Suit.SPADES));
        // System.out.println("Sorted hand with exception throws");
        // h.sort();

        // system can also store with
        System.out.println();
        System.out.println("File named hand.txt created on desktop with the hand");
        h.store("hand.txt");
 
    }
}
