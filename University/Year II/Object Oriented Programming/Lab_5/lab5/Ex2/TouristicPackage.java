package Ex2;

import java.util.*;

public class TouristicPackage{
    private String name;
    private int id;
    private double price;
    private ArrayList<Attraction> attractions;

    public TouristicPackage(String n, int id, double p){
        this.name = n;
        this.id = id;
        this.price = p;
    }

    public void addAtraction(Attraction a){
        attractions.add(a);
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
