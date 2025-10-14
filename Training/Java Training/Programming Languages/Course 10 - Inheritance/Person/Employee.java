package Person;
import java.util.Calendar;

public class Employee extends Person{
    protected double salary;

    public Employee(String name, String CNP, Calendar birthday, Address address, double salary){
        super(name, CNP, birthday, address);
        this.salary = salary;
    }

    public void increaseSalary(int add){
        salary += add;
    }
    
}
