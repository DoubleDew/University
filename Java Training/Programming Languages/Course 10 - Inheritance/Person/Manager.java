package Person;
import java.util.Calendar;

public class Manager extends Employee{
    private double salary;

    public Manager(String name, String CNP, Calendar birthday, Address address, double salary){
        super(name, CNP, birthday, address, salary);
    }

    public void seeSalary(){
        System.out.println(salary);
    }
}
