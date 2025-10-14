import java.io.*;
import java.util.*;

public class Account implements Comparable<Account>, Storable{
    private String ownerName;
    private GregorianCalendar ownerBDay;
    private String IBAN;
    private double amount;
    private double credit;
    private GregorianCalendar creationDate;
    Bank myb;

    static class Bank{
        private String name;
        private double capital;

        public Bank(String name, double capital){
            this.name = name;
            this.capital = capital;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getCapital() {
            return capital;
        }

        public void setCapital(double capital) {
            this.capital = capital;
        }

        @Override
        public String toString() {
            return "Bank {" +
            " name = " + name + 
            ", capital = " + capital + 
            "}";
        }
    }

    public Account(String ownerName, GregorianCalendar ownerBDay, String IBAN, double amount, double credit, GregorianCalendar creationDate){
        this.ownerName = ownerName;
        this.ownerBDay = ownerBDay;
        this.IBAN = IBAN;
        this.amount = amount;
        this.credit = credit;
        this.creationDate = creationDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public GregorianCalendar getOwnerBDay() {
        return ownerBDay;
    }

    public void setOwnerBDay(GregorianCalendar ownerBDay) {
        this.ownerBDay = ownerBDay;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(GregorianCalendar creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Account {" + 
        "ownerName = " + ownerName + 
        ", ownerBDay = " + ownerBDay + 
        ", IBAN = " + IBAN + 
        ", amount = " + amount + 
        ", credit = " + credit + 
        ", creationDate = " + creationDate + 
        ", myb=" + myb.toString() + 
        "}";
    }

    public static void main(String[] args){
        Bank b = new Bank("BT", 1000000);
        Account a = new Account("John", new GregorianCalendar(2000, 1, 1), "RO123456789", 1000, 500, new GregorianCalendar(2022, 1, 1));

        a.myb = b;
        System.out.println(a.toString());
    
    }

    @Override
    public void store(String file) throws FileNotFoundException {
        FileOutputStream outputFile = new FileOutputStream(file);
        OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
        PrintWriter pw = new PrintWriter(outputStream);
        pw.println("My obj: " + this.toString());
        pw.close();
    }

    @Override
    public void read(String file) throws IOException {
        FileInputStream inputFile = null;
        try{
            inputFile = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(inputFile);
            BufferedReader br = new BufferedReader(reader);
            String sCurrentLine = "";
            while((sCurrentLine = br.readLine()) != null){
                System.out.println(sCurrentLine);
            }
            br.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Account acc){
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this == acc){
            return EQUAL;
        }
        if(this.getIBAN().compareTo(acc.getIBAN()) != EQUAL)
            return this.getIBAN().compareTo(acc.getIBAN());
        if (this.getAmount() < acc.getAmount())
            return BEFORE;
        if (this.getAmount() > acc.getAmount())
            return AFTER;
        return EQUAL;
    }


}