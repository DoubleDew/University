class FleetTest extends Fleet
{

    public FleetTest(double Car1StartOdo, double Car1EndOdo, double Car1Liters, double Car2StartOdo, double Car2EndOdo, double Car2Liters) 
	{
        super(Car1StartOdo, Car1EndOdo, Car1Liters, Car2StartOdo, Car2EndOdo, Car2Liters);
    }

    public static void main(String args[])
	{

        double startKM1 = 100;
        double endKM1 = 250;
        double liters1 = 20;

        double startKM2 = 150;
        double endKM2 = 950;
        double liters2 = 55;

        Fleet fleet = new Fleet(startKM1, endKM1, liters1, startKM2, endKM2, liters2);

        System.out.println("Average fuel consumption for fleet is: " + fleet.averageConsumption() + "L/100 KM");
    }
}