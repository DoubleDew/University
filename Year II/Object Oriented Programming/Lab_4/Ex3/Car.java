package Ex3;
import java.util.*;

public class Car
{
    private String brand;
    private String description;
    private int maxEngineSpeed;

    public Car(String b, String d, int s)
    {
        this.brand = b;
        this.description = d;
        this.maxEngineSpeed = s;
    }

    public String getBrand() 
    {
        return brand;
    }

    public String getDescription() 
    {
        return description;
    }

    public int getMaxEngineSpeed() 
    {
        return maxEngineSpeed;
    }

    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public void setMaxEngineSpeed(int maxEngineSpeed) 
    {
        this.maxEngineSpeed = maxEngineSpeed;
    }

    @Override
    public String toString() 
    {
        return "Car " + this.brand + ", description: " + this.description + ", max speed: " + this.maxEngineSpeed;
    }

    public int compare(Car c1, Car c2)
    {
        return c1.getBrand().compareTo(c2.getBrand());
    }
}

class MyCar implements Comparator<Car>
{
    @Override
    public int compare(Car c1, Car c2)
    {
        return c1.getBrand().compareTo(c2.getBrand());
    }
}
