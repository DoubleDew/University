package HW_2;

public class Portfolio {

    private Share[] shares = new Share[50];
    private int noShares;

    public Portfolio()
    {
        this.noShares = 0;
    }

    public void addShare(Share s)
    {
        this.noShares++;
        this.shares[noShares] = s;
    }

    public double computeSum()
    {
        double sum = 0;
        for(int i = 1; i <= noShares; i++)
            sum += this.shares[i].value;
        return sum;
    }

    public static void main(String args[])
    {
        Portfolio p = new Portfolio();
        Company c1 = new Company("Ubisoft");
        Share s1 = new Share(1200, c1);
        Share s2 = new Share(500, c1);
        Share s3 = new Share(700, c1);
        Company c2 = new Company("Apple");
        Share s4 = new Share(800, c2);
        Share s5 = new Share(900, c2);
        Share s6 = new Share(100, c2);

        p.addShare(s1);
        p.addShare(s2);
        p.addShare(s3);
        p.addShare(s4);
        p.addShare(s5);
        p.addShare(s6);

        System.out.println(p.computeSum());
    }
}
