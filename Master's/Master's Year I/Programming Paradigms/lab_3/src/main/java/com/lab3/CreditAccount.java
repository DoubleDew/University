package com.lab3;

public class CreditAccount extends Account{
    private int maxCredit;

    public CreditAccount(String iban, int ammount, int maxCredit) {
        super(iban, ammount);
        this.maxCredit = maxCredit;
    }

    @Override
    public boolean withdraw(int ammount){
        if(ammount <= this.ammount + maxCredit){
            this.ammount -= ammount;
            return true;
        }
        return false;
    }
}