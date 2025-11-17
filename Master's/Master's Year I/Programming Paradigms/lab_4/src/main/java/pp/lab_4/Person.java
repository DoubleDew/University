package pp.lab_4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Person implements Comparable<Person>, Storable
{
    private String name;
    private LocalDate bday;
    private String gender;
    private int height;

    public Person(String name, LocalDate bday, String gender, int height)
    {
        this.name = name;
        this.bday = bday;
        this.gender = gender;
        this.height = height;
    }

    @Override
    public int compareTo(Person other)
    {
        if(this == other)
            return 0;
        if(this.name.compareTo(other.name) != 0)
            return this.name.compareTo(other.name);
        if(!this.bday.isEqual(other.bday))
            return this.bday.compareTo(other.bday);
        if(this.gender.compareTo(other.gender) != 0)
            return this.gender.compareTo(other.gender);
        if(this.height != other.height)
            return this.height - other.height;
        return 0;
    }

    @Override
    public String toString()
    {
        return this.name + ", " + this.bday + ", " + this.gender + ", " + this.height;
    }

    @Override
    public void store(String file) throws FileNotFoundException
    {
        PrintWriter pw = new PrintWriter(file);
        pw.println(this);
        pw.close();
    }
}