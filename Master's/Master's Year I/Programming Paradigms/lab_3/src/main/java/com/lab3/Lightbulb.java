package com.lab3;

public class Lightbulb {
    private boolean turnedOn;
    private final int power;
    
    public Lightbulb(int power){
        this.power=power; }
        
    public int getPower(){return power;}

    public boolean isTurnedOn(){return turnedOn;}

    public void turnOn(){turnedOn=true;}

    public void turnOff(){turnedOn=false;}
}