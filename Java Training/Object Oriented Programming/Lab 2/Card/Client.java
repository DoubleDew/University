import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Client implements Comparable<Card>, Storable{
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

    @Override
    public void store(String file) throws FileNotFoundException{
        FileOutputStream outputFile = new FileOutputStream(file);
        OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
        PrintWriter pw = new PrintWriter(outputStream);
        pw.println(this.toString());
        pw.close();
    }

    @Override
    public void read(String file) throws IOException{
        FileInputStream inputFile = null;
        try{
            inputFile = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(inputFile);
            BufferedReader br = new BufferedReader(reader);
            String sCurrentLine = "";
            while((sCurrentLine = br.readLine()) != null){
                System.out.println(sCurrentLine);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Client cl){
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this == cl){
            return EQUAL;
        }
        if(CNP.compareTo(cl.getCNP()) != EQUAL){
            return CNP.compareTo(cl.getCNP());
        }
        if(this.cards.size() < cl.getCards().size()){
            return BEFORE;
        }
        if(this.cards.size() > cl.getCards().size()){
            return AFTER;
        }
        return EQUAL;
    }

    @Override
    public String toString(){
        return "Client {" + 
            "name = " + name + '\'' +  
            ", bday = " + bday +
            ", CNP = " + CNP + '\'' +
            ", address = " + address +
            ", maxSize = " + maxSize +
            ", cards = " + cards +
            "}";
    }

    public static void main(String[] args) {
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

        try {
            client.store("info.txt");
            try{
                client.read("info.txt");
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

        System.out.println(client.compareTo(cc));
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

    public void setCNP(String CNP) {
        this.CNP = CNP;
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

    @Override
    public int compareTo(Card arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
