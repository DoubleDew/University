public class InsuranceTest 
{
    public static void main(String[] args)
    {
        LifeInsurance lifeInsurance = new LifeInsurance("Selina", "Kyle", "Gotham St");
        AccidentInsurance accidentInsurance = new AccidentInsurance("Bruce", "Wayne", "Hope St", "half-yearly");

        lifeInsurance.computeAmountPerPeriod();
        accidentInsurance.computeAmountPerPeriod();

        accidentInsurance.computeSum();
        lifeInsurance.computeSum();

        System.out.println(accidentInsurance);
        System.out.println(lifeInsurance);
    }
}