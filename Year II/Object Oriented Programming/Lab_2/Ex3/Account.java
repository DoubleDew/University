import java.io.*;
import java.util.*;
import main.java.Storable;


public class Account implements Comparable<Account>, Storable
{
    private String ownerName;
    private GregorianCalendar ownerBDay;
    public String IBAN;
    private double amount;
    private double credit;
    public GregorianCalendar creationDate;
    Bank bb;

    public Account(String name, GregorianCalendar bday, String iban, double a, double c, GregorianCalendar cdate)
    {
        this.ownerName = name;
        this.ownerBDay = bday;
        this.IBAN = iban;
        this.amount = a;
        this.credit = c;
        this.creationDate = cdate;
    }

    public void store(String file) throws FileNotFoundException
    {
        FileOutputStream outputFile = new FileOutputStream("in.txt");
        OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
        PrintWriter pw = new PrintWriter(outputStream);
        pw.println(this.toString());
    }

    public void read(String file) throws IOException
    {
        FileInputStream inputFile = new FileInputStream("in.txt");
        InputStreamReader reader = new InputStreamReader(inputFile);
        BufferedReader br = new BufferedReader(reader);
        String sCurrentLine = "";
        while((sCurrentLine = br.readLine()) != null) System.out.println(sCurrentLine);
    }

    @Override
    public int compareTo(Account a)
    {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if(this == a) return EQUAL;
        if(this.getIBAN().compareTo(a.getIBAN()) != EQUAL) return this.getIBAN().compareTo(a.getIBAN());
        if(this.getAmount() < a.getAmount()) return BEFORE;
        if(this.getAmount() > a.getAmount()) return AFTER;
        return 0;
    }

    static class Bank
    {
        private String name;
        private double capital;

        public Bank(String n, double c)
        {
            this.name = n;
            this.capital = c;
        }

        public double getCapital() 
        {
            return capital;
        }

        public String getName() 
        {
            return name;
        }

        public void setCapital(double capital) 
        {
            this.capital = capital;
        }

        public void setName(String name) 
        {
            this.name = name;
        }

        @Override
        public String toString() 
        {
            return "Bank: name: " + this.name + ", capital: " + this.capital;
        }
    }

    public double getAmount() 
    {
        return amount;
    }

    public GregorianCalendar getCreationDate() 
    {
        return creationDate;
    }

    public double getCredit() 
    {
        return credit;
    }

    public String getIBAN() 
    {
        return IBAN;
    }

    public GregorianCalendar getOwnerBDay() 
    {
        return ownerBDay;
    }

    public String getOwnerName() 
    {
        return ownerName;
    }

    public void setAmount(double amount) 
    {
        this.amount = amount;
    }

    public void setCreationDate(GregorianCalendar creationDate) 
    {
        this.creationDate = creationDate;
    }

    public void setCredit(double credit) 
    {
        this.credit = credit;
    }

    public void setIBAN(String iBAN) 
    {
        IBAN = iBAN;
    }

    public void setOwnerBDay(GregorianCalendar ownerBDay) 
    {
        this.ownerBDay = ownerBDay;
    }

    public void setOwnerName(String ownerName) 
    {
        this.ownerName = ownerName;
    }

    public static void main(String[] args)
    {
        Bank b = new Bank("Revolut", 10000);
        Account a = new Account("Dan Deaconu", new GregorianCalendar(2002,2,20), "RO123456", 2000, 1000, new GregorianCalendar(2020,1,20));
        a.bb = b;
        System.out.println(a.toString());
    }
}