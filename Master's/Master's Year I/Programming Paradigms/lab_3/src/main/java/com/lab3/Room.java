package com.lab3;

import java.util.ArrayList;
import java.util.List;

public class Room {

//default Room() { super();}

    List<Lightbulb> bulbs=new ArrayList<>();

    public void turnAllOn(){
        for(Lightbulb l : bulbs)
            l.turnOn();
    }

    public void turnAllOff(){
        for(Lightbulb l : bulbs)
            l.turnOff();    
    }

    public int getMaxPower(){
        int sum=0;
        
        for(Lightbulb l : bulbs)
            sum+=l.getPower();

        return sum;
    }

    public int getInstantPower(){
        int sum=0;

        for(Lightbulb l : bulbs)
            if(l.isTurnedOn())
                    sum+=l.getPower();

        return sum;
    }

    public void addBulb(Lightbulb l){
        bulbs.add(l);
    }

}