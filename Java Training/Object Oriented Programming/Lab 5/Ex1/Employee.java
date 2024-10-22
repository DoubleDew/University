public class Employee{
    private String name;
    private String CNP;
    private int salary;

    public Employee(String name, String CNP, int salary){
        this.name = name;
        this.CNP = CNP;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String cNP) {
        CNP = cNP;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString(){
        return "Name: " + name + ", CNP: " + CNP + ", Salary: " + salary;
    }
}