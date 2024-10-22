public class Employee {
    private final String name;
    private double salary;
    private int id;
    private static int nextId = 1;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        id = getNextId();
    }

    public String getName() {
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public int getId(){
        return id;
    }

    public void setId(){
        id = nextId;
    }

    public static int getNextId() {
        return nextId++;
    }

    public static void display(int k, String... data) {
        System.out.println("k: " + k + ", data size: " + data.length);
    }

    public static void main(String[] args){
        Employee e = new Employee("John", 50000);
        System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());

        Employee e2 = new Employee("Don", 40000);
        System.out.println(e2.getId() + " " + e2.getName() + " " + e2.getSalary());

        display(0);
        display(1, "one");
        display(2, "one", "two");
        display(3, new String[] {"one", "two"});
    }
}