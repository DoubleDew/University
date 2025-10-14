import java.util.Comparator;

public class Car{
    private String brand;
    private String description;
    private int maxEngineSpeed;

    public Car(String brand, String description, int maxEngineSpeed){
        this.brand = brand;
        this.description = description;
        this.maxEngineSpeed = maxEngineSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxEngineSpeed() {
        return maxEngineSpeed;
    }

    public void setMaxEngineSpeed(int maxEngineSpeed) {
        this.maxEngineSpeed = maxEngineSpeed;
    }

    public String toString(){
        return "Brand: " + brand + "\nDescription: " + description + "\nMax Engine Speed: " + maxEngineSpeed;
    }
}

class MyCar implements Comparator<Car>{
    @Override
    public int compare(Car c1, Car c2){
        return c1.getDescription().compareTo(c2.getDescription());
    }
}