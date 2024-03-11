//package Course 7;

public class Rational 
{
    private int numerator;
    private int denominator;

    public Rational()
    {
        numerator = 0;
        denominator = 1;
    }

    public static int cmmdc(int a, int b)
    {
        if(b==0)
            return a;
        return cmmdc(b,a%b);    
    }

    public Rational(int num, int den)
    {
        numerator = num;
        denominator = den;
    }

    public Rational add(Rational a, Rational b)
    {
        int num = (a.numerator * b.denominator) + (b.numerator * a.denominator);
        int den = a.denominator * b.denominator;
        int cmmdc = cmmdc(num,den);
        num = num / cmmdc; 
        den = den / cmmdc;
        Rational sum = new Rational(num,den);
        return sum;
    }

    public Rational sub(Rational a, Rational b)
    {
        int num = (a.numerator * b.denominator) - (b.numerator * a.denominator);
        int den = a.denominator * b.denominator;
        int cmmdc = cmmdc(num,den);
        num = num / cmmdc;
        den = den / cmmdc;
        Rational sub = new Rational(num,den);
        return sub;
    }

    public Rational mult(Rational a, Rational b)
    {
        int num = (a.numerator * b.denominator) * (b.numerator * a.denominator);
        int den = a.denominator * b.denominator;
        int cmmdc = cmmdc(num,den);
        num = num / cmmdc;
        den = den / cmmdc;
        Rational mult = new Rational(num,den);
        return mult;
    }

    public Rational div(Rational a, Rational b)
    {
        int num = a.numerator * b.denominator;
        int den = a.denominator * b.numerator;
        int cmmdc = cmmdc(num,den);
        num = num / cmmdc;
        den = den / cmmdc;
        Rational div = new Rational(num,den);
        return div;
    }
    
    public void intFormat()
    {
        System.out.println(numerator + "/" + denominator);
    }

    public void realFormat()
    {
        float number = (float)numerator / (float)denominator;
        System.out.println(number);
    }
}