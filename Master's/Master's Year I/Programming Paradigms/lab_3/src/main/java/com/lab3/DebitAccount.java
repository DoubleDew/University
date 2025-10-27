package com.lab3;

public class DebitAccount extends Account{
    public DebitAccount(String iban, int ammount) {
        super(iban, ammount);
    }

    @Override
    public boolean withdraw(int ammount){
        if(ammount <= this.ammount){
            this.ammount -= ammount;
            return true;
        }
        return false;
    }
}