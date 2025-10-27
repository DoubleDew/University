package com.lab3;

import java.util.Calendar;

public class ConferenceProceeding extends Publication{
    private String volumeName;
    private boolean indexed;

    public ConferenceProceeding(String volumeName, boolean indexed, String name, Calendar apparition, int numberOfAuthors) {
        super(name, apparition, numberOfAuthors);
        this.volumeName = volumeName;
        this.indexed = indexed;
    }

    @Override
    public double calculateScore(){
        if(this.indexed)
            return 0.25/this.getNumberOfAuthors();
        else
            return 0.2/this.getNumberOfAuthors();
    }
}