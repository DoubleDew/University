import java.util.*;

public class Main {
    public static void main(String[] args){
        Flight f1 = new Flight("airline1_flight1");
        Flight f2 = new Flight("airline1_flight2");
        Flight f3 = new Flight("airline1_flight3");

        f1.addFeedback(2, "acceptable");
        f2.addFeedback(3, "good");
        f3.addFeedback(4, "great");

        f1.features.add("cup holders");
        f1.features.add("pillows");
        f1.features.add("champagne");
        
        f2.features.add("cup holders");
        f2.features.add("warm food");
        f2.features.add("free chocolate");

        f3.features.add("cup holders");
        f3.features.add("pillows");
        f3.features.add("drinks");

        f1.computeOverallRating();
        System.out.println("Flight 1 rating = " + f1.getOverallRating());

        Airline a1 = new Airline("Tarom", "Bucharest", "0773965751");
        a1.addFlight(f1);
        a1.addFlight(f2);
        a1.addFlight(f3);

        Platform p = new Platform();
        p.addAirline(a1);
        p.featureFreq();

        System.out.println(p.frequency);
    }
}
