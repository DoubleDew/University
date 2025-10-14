package Ex1;

import java.util.HashMap;
import java.util.*;

public class Employee
{
    private String name;
    private int id;
    private String emailAddress;
    private String phoneNo;
    
    public Employee(String n, int id, String e, String p)
    {
        this.name = n;
        this.id = id;
        this.emailAddress = e;
        this.phoneNo = p;
    }

    @Override
    public String toString() 
    {
        return "Employee " + this.name + ": ID " + this.id + ", email address " + this.emailAddress + ", phone no. " + this.phoneNo + ".";
    }

    public String getName() 
    {
        return name;
    }
}

class Main{
    public static void main(String[] args){
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        Map<String, Employee> employees = new HashMap<String, Employee>();

        employeeList.add(new Employee("Name 1", 101, "name1@email.com", "+1100000001"));
        employeeList.add(new Employee("Name 2", 101, "name2@email.com", "+1100000002"));
        employeeList.add(new Employee("Name 3", 101, "name31@email.com", "+1100000003"));
        employeeList.add(new Employee("Name 4", 101, "name4@email.com", "+1100000004"));
        employeeList.add(new Employee("Name 5", 101, "name5@email.com", "+1100000005"));
        employeeList.add(new Employee("Name 6", 101, "name6@email.com", "+1100000006"));
        employeeList.add(new Employee("Name 7", 101, "name7@email.com", "+1100000007"));
        employeeList.add(new Employee("Name 8", 101, "name8@email.com", "+1100000008"));
        employeeList.add(new Employee("Name 9", 101, "name9@email.com", "+1100000009"));
        employeeList.add(new Employee("Name 10", 101, "name10@email.com", "+1100000010"));

        for(Employee e : employeeList)
        {
            employees.put(e.getName(), e);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String searchedName = sc.nextLine();

        for(Map.Entry<String, Employee> e : employees.entrySet())
        {
            if(employees.get(e).equals(searchedName)) System.out.println(e);
        }
    }
}