package NestedClass;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

public class Account implements Comparable<Account>, Storable {
    private String ownerName;
    private GregorianCalendar ownerBDay;
    private String IBAN;
    private double amount;
    private double credit;
    private GregorianCalendar creationDate;
    
    Bank b;

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

    public Bank getB() {
        return b;
    }

    public void setB(Bank b) {
        this.b = b;
    } 

    class Bank {
        private String bank;
        private double capital;

        public Bank(String bank, double capital){
            this.bank = bank;
            this.capital = capital;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public double getCapital() {
            return capital;
        }

        public void setCapital(double capital) {
            this.capital = capital;
        }

        @Override
        public String toString() {
            return "Bank{" + 
            "bank=" + bank + 
            ", capital=" + capital + 
            '}';
        }
    }

    @Override
    public void store(String file) throws FileNotFoundException {
        FileOutputStream outputFile = new FileOutputStream(file);
        OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
        PrintWriter pw = new PrintWriter(outputStream);
        pw.println("My account: " + this.toString());
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
    public String toString() {
    return "Account [ownerName=" + ownerName + 
    ", ownerBDay=" + ownerBDay + 
    ", IBAN=" + IBAN + 
    ", amount=" + amount + 
    ", credit=" + credit + 
    ", creationDate=" + creationDate + 
    ", b=" + b + "]";
}

    @Override
    public int compareTo(Account a){
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this == a){
            return EQUAL;
        }
        if(this.getOwnerName().compareTo(a.getOwnerName()) != EQUAL){
            return this.getOwnerName().compareTo(a.getOwnerName());
        }
        if(this.getIBAN().compareTo(a.getIBAN()) != EQUAL){
            return this.getIBAN().compareTo(a.getIBAN());
        }
        if(this.getAmount() < a.getAmount()){
            return BEFORE;
        }
        if(this.getAmount() > a.getAmount()){
            return AFTER;
        }
        return EQUAL;
    }
}
