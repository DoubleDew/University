import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Client {
    private String name, CNP;
    private GregorianCalendar bday;
    private List<Card> cards = new ArrayList<>();
    private int maxSize = 10;
    private Address address;

    public boolean addCard(Card c){

        // this.cards.add(c);
        // return true;
        // This approach was done in the first place, but it was not the best one, because it was not checking if the list was full or not.

        if(this.cards.size() < this.maxSize){
            this.cards.add(c);
            System.out.println("Card succesfully added!");
            return true;
        }
        else{
            return false;
        }

    }

    public Card removeCard(String iban){
        Card c = null;
        for (Card cc : cards)
            if(cc.getIBAN().equalsIgnoreCase(iban)){
                c = cc; 
                this.cards.remove(c);
                System.out.println("Card succesfully removed!");
            }
        return c;
    }

    public static void main(String[] args){
        Address address = new Address("Bucharest", "Strada Oituz", 85);
        DebitCard dc = new DebitCard("RO12354654", 1000);
        CreditCard cc = new CreditCard("RO2312523564", 2000, 5000);
        Client client = new Client("John Doe", "12346463123", new GregorianCalendar(2002, 1, 20), address);

        client.setAddress(address);
        client.cards.add(dc);
        client.cards.add(cc);

        System.out.println();
        System.out.println(client.getName()); 
        System.out.println(client.getCNP());
        System.out.println(client.getBday().getTime());
        System.out.println(client.getAddress().getCity());
        System.out.println(client.getAddress().getStreet());
        System.out.println(client.getAddress().getNumber());

        System.out.println();
        dc.withdraw(500);

        System.out.println();
        for(Card c : client.cards){
            System.out.println(c.getIBAN());
            System.out.println(c.getAmount());
        }

        System.out.println();
        client.removeCard("RO12354654");

        System.out.println();
        for(Card c : client.cards){
            System.out.println(c.getIBAN());
            System.out.println(c.getAmount());
        }
    }

    public Client(String name, String cnp, GregorianCalendar bday, Address address){
        this.name = name;
        this.CNP = cnp;
        this.bday = bday;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String cNP) {
        CNP = cNP;
    }

    public GregorianCalendar getBday() {
        return bday;
    }

    public void setBday(GregorianCalendar bday) {
        this.bday = bday;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
