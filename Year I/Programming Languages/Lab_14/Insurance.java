abstract class Insurance
{
    private int id = 0;
    private int number;
    private String firstName;
    private String lastName;
    private String address;
    protected double amountPerPeriod;
    protected String frequency;
    private double sum = 0.0;

    public Insurance(String fN, String lN, String a)
    {
        this.id++;
        this.firstName = fN;
        this.lastName = lN;
        this.address = a;
        this.amountPerPeriod = 13;
        this.frequency = "monthly";
        this.number = id;
    }

    public Insurance(String fN, String lN, String a, String f)
    {
        this.id++;
        this.firstName = fN;
        this.lastName = lN;
        this.address = a;
        this.frequency = f;
        this.amountPerPeriod = 13;
        this.number = id;
    }

    public abstract void computeAmountPerPeriod();

    public void computeSum()
    {
        this.sum += this.amountPerPeriod;
    }

    public double getSum() 
    {
        return sum;
    }

    public String getFrequency()
    {
        return frequency;
    }

    @Override
    public String toString() 
    {
        return "ID: " + this.number + ", first name: " + this.firstName + ", last name: " + this.lastName + ", address: " + this.address + ", amount per period: "
                + this.amountPerPeriod + ", frequency: " + this.frequency + ", total sum: " + this.sum;
    }
}

class LifeInsurance extends Insurance
{
    public LifeInsurance(String fN, String lN, String a)
    {
        super(fN, lN, a);
    }

    public LifeInsurance(String fN, String lN, String a, String f)
    {
        super(fN, lN, a, f);
    }

    @Override
    public void computeAmountPerPeriod() 
    {
        if(super.frequency.equals("quarterly"))  this.amountPerPeriod += 0.02 * this.amountPerPeriod;
    }
}

class AccidentInsurance extends Insurance
{
    public AccidentInsurance(String fN, String lN, String a)
    {
        super(fN, lN, a);
    }

    public AccidentInsurance(String fN, String lN, String a, String f)
    {
        super(fN, lN, a, f);
    }

    @Override
    public void computeAmountPerPeriod() 
    {
        if(super.frequency.equals("half-yearly")) this.amountPerPeriod += 0.05 * this.amountPerPeriod;
    }
}