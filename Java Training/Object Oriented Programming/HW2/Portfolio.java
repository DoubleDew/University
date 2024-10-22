import java.util.*;

public class Portfolio {
    private List<Share> shares = new ArrayList<Share>();
    private int noShares;

    public Portfolio(int noShares){
        this.noShares = 0;
    }

    public void addShare(Share s){
        shares.add(s);
        noShares++;
    }

    public double computeSum(){
        double sum = 0;
        for(Share s: shares){
            sum += s.getValue();
        }
        return sum;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public int getNoShares() {
        return noShares;
    }

    public void setNoShares(int noShares) {
        this.noShares = noShares;
    }

    public static void main(String[] args) {
        Portfolio p = new Portfolio(6);
        Company c1 = new Company("Ubisoft");
        Share s1 = new Share(1200,c1);
        Share s2 = new Share(500,c1);
        Share s3 = new Share(700,c1);
        Company c2 = new Company("Apple");
        Share s4 = new Share(800,c2);
        Share s5 = new Share(900,c2);
        Share s6 = new Share(100,c2);

        p.addShare(s1); 
        p.addShare(s2); 
        p.addShare(s3); 
        p.addShare(s4);
        p.addShare(s5); 
        p.addShare(s6);
        
        for(Share s: p.getShares()){
            System.out.println("\n" + s.getCompany().getName());
            System.out.println(s.getValue());
        }

        System.out.println("\n" + p.computeSum());
    }
}
