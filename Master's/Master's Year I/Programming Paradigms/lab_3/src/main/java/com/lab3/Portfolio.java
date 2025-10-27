package com.lab3;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Share> shares = new ArrayList<>();
    private int noShares = 0;

    public void addShare(Share s){
        shares.add(s);
        noShares++;
    }

    public double computeSum(){
        double sum = 0;

        for(Share s : shares){
            sum += s.getValue();
        }

        return sum;
    }
}