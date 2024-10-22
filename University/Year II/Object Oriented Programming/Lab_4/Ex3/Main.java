package Ex3;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        TreeSet<Car> carSet = new TreeSet<>(new MyCar());

        Car c1 = new Car("Ford", "Sedan", 150);
        Car c2 = new Car("Audi", "SUV", 150);
        Car c3 = new Car("Mercedes", "Sedan", 120);
        Car c4 = new Car("Toyota", "SUV", 170);
        Car c5 = new Car("McLaren", "Hyper", 400);

        carSet.add(c1);
        carSet.add(c2);
        carSet.add(c3);
        carSet.add(c4);
        carSet.add(c5);

        for(Car c : carSet) System.out.println(c);
        System.out.println(c1.compare(c1, c2));
    }
}
