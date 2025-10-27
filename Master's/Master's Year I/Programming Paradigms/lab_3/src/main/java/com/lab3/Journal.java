package com.lab3;

import  java.util.Calendar;

public class Journal extends Publication{
    private String journalName;
    private double impactFactor;

    public Journal(String journalName, String name, Calendar apparition, int noOfAuthors, double impactFactor) {
        super(name, apparition, noOfAuthors);
        this.journalName = journalName;
        this.impactFactor = impactFactor;
    }

    @Override
    public double calculateScore(){
        return (impactFactor * 0.5) / this.getNumberOfAuthors();
    }
}