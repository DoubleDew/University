import java.util.*;

public class Flight implements Comparable<Flight>{

    private String name;
    private double overallRating;
    Set<String> features = new HashSet<String>();
    ArrayList<Rating> ratings = new ArrayList<>();

    public Flight(String name) {
        this.name = name;
    }

    public void computeOverallRating(){
        double total = 0;
        int count = 0;
        for(Rating r : ratings){
            total += r.getNoStars();
            count++;
        }
        overallRating = total / count;
    }

    public void addFeedback(int noStars, String description){
        //to add feedback for a flight
        ratings.add(new Rating(noStars, description));
        computeOverallRating();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(double overallRating) {
        this.overallRating = overallRating;
    }

    public Set<String> getFeatures() {
        return features;
    }

    public void setFeatures(Set<String> features) {
        this.features = features;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compareTo(Flight fl) {
        if(this.overallRating == fl.getOverallRating() && this.name.equalsIgnoreCase(fl.name))
            return 0;
        else 
            if(this.overallRating > fl.getOverallRating())
                return 1;
            else 
                return -1;
    }
    
}
