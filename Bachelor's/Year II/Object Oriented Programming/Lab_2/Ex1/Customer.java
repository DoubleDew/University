import java.util.*;

public class Customer
{
    private String username;
    private int maxproducts = 50;
    private List<SoftwareProduct> softp = new ArrayList<>();
    private Computer computer;

    public Customer(String u, Computer comp)
    {
        this.username = u;
    }

    public Computer gComputer()
    {
        return computer;
    }

    public void setComputer(Computer computer)
    {
        this.computer = computer;
    }

    public void addProduct(SoftwareProduct sp)
    {
        if(softp.size() < maxproducts)
        {
            softp.add(sp);
            System.out.println("Product added");
        }
        else System.out.println("Limit reached");
    }

    public void removeProduct(String name)
    {
        for(SoftwareProduct sps : softp)
        {
            if(sps.getName().equalsIgnoreCase(name))
            {
                this.softp.remove(sps);
                System.out.println("Removed successfully");
            }
            else System.out.println("Can't find product");
        }
    }

    public static void main (String args []) throws Exception
    {
        Computer c = new Computer(8, "i7");
        OfficeProduct op = new OfficeProduct("Office", "Windows");
        GameProduct gp = new GameProduct("Minecraft", "Windows");
        Customer cust = new Customer("DoubleDew", c);
        cust.addProduct(op);
        cust.addProduct(gp);
        for(SoftwareProduct sop : cust.softp)
            System.out.println(sop.getName() + " , " + sop.getPlatform());
        cust.removeProduct("Office");
        for(SoftwareProduct sop : cust.softp)
            System.out.println(sop.getName() + " , " + sop.getPlatform());
    }
}