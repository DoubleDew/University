package com.lab3;

import java.time.LocalDate;
import java.util.*;

public class Client {
    private String name;
    private LocalDate bday;
    private String cnp;
    private Address address;
    private List<Account> accounts = new ArrayList<>();
    
    public Client(String name, LocalDate bday, String cnp, Address address) {
        this.name = name;
        this.bday = bday;
        this.cnp = cnp;
        this.address = address;
    }

    public void addAccount(Account a){
        accounts.add(a);
    }

    public boolean removeAccount(String iban){
        Iterator<Account> it = accounts.iterator();
        while(it.hasNext()){
            Account acc = it.next();
            if(acc.getIBAN().equals(iban)){
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return name + " (" + cnp + "), born " + bday + ", Address: " + address;
    }

    public void showAccounts(){
        for(Account a : accounts)
            System.out.println(" - " + a.getClass().getSimpleName() + " [" + a.getIBAN() + "] Balance: " + a.getAmmount());
    }
}