public class OfficeProduct extends SoftwareProduct
{
    public OfficeProduct(String n, String p)
    {
        super(n,p);
    }

    @Override
    public boolean CheckCompatibility()
    {
        if(this.getPlatform().equalsIgnoreCase("Dumbass"))
            return true;
        else return false;
    }
}