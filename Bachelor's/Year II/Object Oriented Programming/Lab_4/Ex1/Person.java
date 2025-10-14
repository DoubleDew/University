package Ex1;
public class Person
{
    private String name;
    private String cnp;
    private String address;

    public Person(String name, String cnp, String address)
    {
        this.name = name;
        this.cnp = cnp;
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Person: " + this.name + " CNP: " + this.cnp + " Address: " + this.address;
    }
}