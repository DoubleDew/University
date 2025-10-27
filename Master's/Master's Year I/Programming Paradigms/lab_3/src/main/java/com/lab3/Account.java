package com.lab3;

public abstract class Account {
    private String iban;
    protected int ammount;

    public Account(String iban, int ammount) {
        this.iban = iban;
        this.ammount = ammount;
    }

    public String getIBAN(){
        return iban;
    }

    public int getAmmount(){
        return ammount;
    }

    public void deposit(int ammount){
        if(ammount > 0){
            this.ammount += ammount;
        }
    }

    public abstract boolean withdraw(int ammount);
}