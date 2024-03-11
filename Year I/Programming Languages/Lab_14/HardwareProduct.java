abstract class HardwareProduct 
{
    protected double currentPrice;
    protected double leiPrice;
    protected double score;
    protected double performance;

    public HardwareProduct(double cP, double s)
    {
        this.currentPrice = cP;
        this.score = s;
    }

    public abstract void computePerformance();

    public abstract String toString();

    public abstract void computePriceInLei();

    public abstract double computeRatioLeiPricePerformance();
}

class VideoCard extends HardwareProduct
{
    private double currency;
    private int maximumScore;

    public VideoCard(double cP, double s)
    {
        super(cP, s);
        this.currency = 5;
        this.maximumScore = 100;
    }

    @Override
    public void computePriceInLei()
    {
        super.leiPrice = super.currentPrice * this.currency;
    }

    @Override
    public void computePerformance()
    {
        super.performance = super.score/this.maximumScore * 100;
    }

    @Override
    public double computeRatioLeiPricePerformance()
    {
        return super.leiPrice/super.performance;
    }
    
    @Override
    public String toString()
    {
        return "VideoCard: price - " + super.leiPrice + ", score - " + super.score + ", performance - " + super.performance + ", ratio - " + computeRatioLeiPricePerformance(); 
    }
}

class Monitor extends HardwareProduct
{
    private double currency;
    private int maximumScore;
    
    public Monitor(double cP, double s)
    {
        super(cP, s);
        this.currency = 4.5;
        this.maximumScore = 150;
    }

    @Override
    public void computePriceInLei()
    {
        super.leiPrice = super.currentPrice * this.currency;
    }

    @Override
    public void computePerformance()
    {
        super.performance = super.score/this.maximumScore * 100;
    }

    @Override
    public double computeRatioLeiPricePerformance()
    {
        return super.leiPrice/super.performance;
    }

    @Override
    public String toString() 
    {
        return "Monitor: price - " + super.leiPrice + ", score - " + super.score + ", performance - " + super.performance + ", ratio - " + computeRatioLeiPricePerformance(); 
    }
}