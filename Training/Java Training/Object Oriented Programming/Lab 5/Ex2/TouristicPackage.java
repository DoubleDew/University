import java.util.*;

public class TouristicPackage{
    private String name;
    private int id;
    private int price;
    private ArrayList<Attraction> attractions = new ArrayList<>();

    public TouristicPackage(String name, int id, int price){
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public String toString(){
        return "TouristicPackage{ " + 
            " name = " + name + "\'" +
            ", id=" + id + 
            ", price=" + price + 
            "}";
    }

    
}