public class Weather 
{
    private int day;
    private int month;
    private int year;
    private int highTemp;
    private int lowTemp;
    private int prec;
    private int snow;

    public Weather(int m, int d, int y, int hT, int lT, int p, int s)
    {
        this.day = d;
        this.month = m;
        this.year = y;
        this.highTemp = hT;
        this.lowTemp = lT;
        this.prec = p;
        this.snow = s;
    }

    public int getYear() 
    {
        return year;
    }

    public int getPrec() 
    {
        return prec;
    }

    public int getSnow() 
    {
        return snow;
    }

    public int getMonth() 
    {
        return month;
    }

    public int getHighTemp() 
    {
        return highTemp;
    }

    public int getLowTemp() 
    {
        return lowTemp;
    }
}