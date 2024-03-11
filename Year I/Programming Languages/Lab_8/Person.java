public class Person 
{
    private String firstName;
    protected String lastName;
    private int age;

    public Person(String firstName, String lastName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void displayPerson()
    {
        System.out.println(firstName + " " + lastName + ", age " + age);
    }

    public String getLast() 
    {
        return lastName;
    }
}