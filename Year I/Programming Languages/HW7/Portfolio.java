public class Portfolio
{
    private int noShares; 
    private Share[] shares= new Share[100];
    public Portfolio()
    {
        this.noShares=0;                
    }
    public void addShare(Share s)
    {
        this.noShares++;
        this.shares[noShares]=s;        
    }    
    public double computeSum()
    { 
        double a=0;
        for(int i=1; i<=noShares;i++)
            a=a + this.shares[i].value;
        return a;
    }
}
class Share
{
    double value;
    Company company;
    public Share()
    {       
        this.value=0;       
    }
    public Share(double value, Company company )
    {       
        this.value=value;
        this.company=company;
    }
}
class Company
{
    String nume;
    public Company(String name)
    {
        this.nume=name;
    }    
}