public class GameProduct extends SoftwareProduct
{
    public GameProduct(String n, String p)
    {
        super(n,p);
    }

    @Override
    public boolean CheckCompatibility()
    {
        if(this.getPlatform().equalsIgnoreCase("Windows"))
        {
            System.out.println("OK");
            return true;
        }
        else
        {
            System.out.println("Not OK");
            return false;
        }
    }
}