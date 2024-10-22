import java.util.*;
import java.io.*;

public class Hand implements Storable{
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card){
        this.cards.add(card);
        System.out.println("Added card:" + card.toString());
    }

    public boolean deleteCard(Card.Rank rank, Card.Suit suit){
        boolean found = false;
        Card temp = null;
        for (Card c : cards){
            if(c.getRank().getText().equalsIgnoreCase(rank.getText()) && c.getSuit().getValue() == suit.getValue()){
                found = true;
                temp = c;
            }
        }

        if(temp != null)
            cards.remove(temp);

        return found;
    }

    public void sort(){
        // sort by suit 
        Collections.sort(cards, new Comparator<Card>(){
            @Override
            public int compare(Card c1, Card c2){
                return c1.getSuit().getValue() - c2.getSuit().getValue();
            }
        });
        

        // sort by rank
        Collections.sort(cards, new Comparator<Card>(){
            @Override
            public int compare(Card c1, Card c2){
                return c1.getRank().compareTo(c2.getRank());
            }
        });

        // sorting by suit, but you can also check if there are any duplicates for a card based on rank and suit
        Collections.sort(cards, new Comparator<Card>(){
            @Override
            public int compare(Card c1, Card c2){
                if(c1.getRank() == c2.getRank() && c1.getSuit() == c2.getSuit())
                    throw new RuntimeException("There are two cards of type: " + c2.getRank() + " of " + c2.getSuit() + ". Someone is cheating!");
                return c1.getSuit().compareTo(c2.getSuit());
            }
        });
    }

    public void display(){
        for (Card c : cards)
            System.out.println(c.toString());
    }

    @Override
    public void store(String file) throws FileNotFoundException{
        FileOutputStream outputFile = new FileOutputStream("hand.txt", true);
        OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
        PrintWriter pw = new PrintWriter(outputStream);
        pw.println("The hand in order: ");
        for(Card c : cards)
            pw.println(c.toString());
        pw.close();
    }

}
