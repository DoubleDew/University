package regular;
class SecondLab1{
    public static void main(String [] args)
    {
        double fraction1 = ((1.0/2.0) + ((3.0/17.0) * (5.0/2.0)) + Math.sqrt(1.0/2.0)) / (2.0/Math.pow(7.0,3.0));
        double fraction2 = ((9.0/2.0) + (3.0/4.0)) / (1.0/Math.pow(3.0,3.0));
        double result = fraction1 * fraction2;

        System.out.println(result);
    }
}