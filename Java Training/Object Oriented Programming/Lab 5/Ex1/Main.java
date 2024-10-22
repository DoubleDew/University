import java.util.*;

public class Main {
    public static void main(String[] args){
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("John", "123456", 5000));
        employees.add(new Employee("Bob", "115621", 3500));
        employees.add(new Employee("Dan", "156512", 5500));
        employees.add(new Employee("Tom", "174611", 6000));
        employees.add(new Employee("Harry", "486510", 7300));
        employees.add(new Employee("Gary", "896251", 12000));
        employees.add(new Employee("Louis", "462045", 5400));
        employees.add(new Employee("Jack", "486213", 3200));
        employees.add(new Employee("Ana", "465123", 8000));
        employees.add(new Employee("Mary", "951235", 9500));

        Map<String, Employee> eMap  = new HashMap<>();
        for(Employee e : employees){
            eMap.put(e.getCNP(), e);
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter CNP: ");
        String cnp = scan.next();

        if(eMap.containsKey(cnp))
            System.out.println("\nEmployee found: " + eMap.get(cnp).toString() + "\n");
        else
            System.out.println("\nEmployee not found!\n");

        System.out.println("All employees: ");
        for(Map.Entry<String, Employee> entry : eMap.entrySet()){
            System.out.println("<K, V>: <" + entry.getKey() + ", " + entry.getValue() + ">");
        }

    }
}
