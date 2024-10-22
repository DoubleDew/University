package Card;

import java.time.LocalDate;
import java.util.*;

public class Client {
    private String name;
    private LocalDate bday;
    private String CNP;

    public Client(String name, LocalDate bday, String cnp){
        this.name = name;
        this.bday = bday;
        this.CNP = cnp;
    }

    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account a){
        this.accounts.add(a);
    }

    public boolean removeAccount(String iban){
        boolean found = false;
        for(Account a : accounts){
            if(a.getIBAN().equalsIgnoreCase(iban)){
                found = true;
                accounts.remove(a);
            }
        }
        return found;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBday() {
        return bday;
    }

    public void setBday(LocalDate bday) {
        this.bday = bday;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String cNP) {
        CNP = cNP;
    }
}