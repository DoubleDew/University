package HW_2;

public class Share 
{
    protected double value;
    private Company company;

    public Share()
    {
        this.value = 0;
    }

    public Share(double v, Company c)
    {
        this.value = v;
        this.company = c;
    }
}
