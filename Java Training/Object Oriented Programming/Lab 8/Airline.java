import java.util.*;

public class Airline {
    private String name, address, phone;
    private double rating;
    ArrayList<Flight> flights = new ArrayList<Flight>();
    
    public Airline(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void computeRating(){
        double total = 0;
        int count = 0;
        for(Flight f : flights){
            total += f.getOverallRating();
            count++;
        }
        rating = total / count;
    }

    public void addFlight(Flight f){
        flights.add(f)
;    }
    
}
