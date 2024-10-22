public abstract class SoftwareProduct
{
    private String name;
    private String platform;

    public SoftwareProduct(String n, String p)
    {
        this.name = n;
        this.platform = p;
    }

    public abstract boolean CheckCompatibility();

    public String getPlatform()
    { 
        return platform;
    } 
    public String getName() 
    { 
        return name; 
    }

    public void setPlatform(String p)
    { 
        this.platform = p; 
    }
    public void setName(String n) 
    { 
        this.name = n; 
    }

}