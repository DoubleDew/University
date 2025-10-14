package Ex2;

public class Attraction
{
    private String location;
    private String name;

    public Attraction(String n, String l)
    {
        this.name = n;
        this.location = l;
    }

    public String getLocation() 
    {
        return location;
    }

    public String getName() 
    {
        return name;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
