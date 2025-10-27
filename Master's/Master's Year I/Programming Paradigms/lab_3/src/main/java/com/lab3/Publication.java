package com.lab3;

import java.util.Calendar;

public abstract class Publication {
    private String name;
    private Calendar apparition;
    private int numberOfAuthors;
    
    public Publication(String name, Calendar apparition, int noOfAuthors) {
        this.name = name;
        this.apparition = apparition;
        this.numberOfAuthors = noOfAuthors;
    }

    public int getNumberOfAuthors(){
        return numberOfAuthors;
    }
    
    public abstract double calculateScore();
}