//package Course7;

public class TestRational 
{
    public static <Rational> void main(String [] args)
    {
        int sumnum = 0, sumden = 0;
        int subnum = 0, subden = 0;
        int multnum = 0, multden = 0;
        int divnum = 0, divden = 0;
        Rational rat1 = new Rational(2,3);
        Rational rat2 = new Rational(4,5);

        Rational s = new Rational(sumnum, sumden);
        Rational subst = new Rational(subnum, subden);
        Rational p = new Rational(multnum, multden);
        Rational d = new Rational(divnum, divden);

        s = s.add(rat1, rat2);
        subst = subst.sub(rat1, rat2);
        p = p.mult(rat1, rat2);
        d = d.div (rat1, rat2);
        
        System.out.println("the sum = ");
        s.intFormat();
        s.realFormat();

        System.out.println("the subst = ");
        subst.intFormat();
        subst.realFormat();

        System.out.println("the mult = ");
        p.intFormat();
        p.realFormat();

        System.out.println("the div = ");
        d.intFormat();
        d.realFormat();
    }
}
