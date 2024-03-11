import main.java.Storable;

public abstract class SoftwareProduct implements Comparable<SoftwareProduct>, Storable
{
    private String name;
    private String platform;

    public SoftwareProduct(String n, String p)
    {
        this.name = n;
        this.platform = p;
    }

    public abstract boolean checkCompatibility();

    public String getName() 
    {
        return name;
    }

    public String getPlatform() 
    {
        return platform;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setPlatform(String platform) 
    {
        this.platform = platform;
    }

    @Override
    public String toString() 
    {
        return "Name: " + this.name + ", platform: " + this.platform;
    }
}