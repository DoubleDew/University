import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        TreeSet<Car> cars = new TreeSet<>(new MyCar());

        Car c1 = new Car("Car E", "Red", 200);
        Car c2 = new Car("Car M", "Blue", 230);
        Car c3 = new Car("Car Z", "Yellow", 180);
        Car c4 = new Car("Car G", "Green", 220);
        Car c5 = new Car("Car A", "Purple", 250);

        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(c4);
        cars.add(c5);

        for(Car c : cars){
            System.out.println(c);
        }
    }
}
