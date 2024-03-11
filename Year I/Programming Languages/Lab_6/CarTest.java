class CarTest extends Car
{
    public CarTest(double startOdo, double endOdo, double litersUsed) 
	{
        super(startOdo, endOdo, litersUsed);
    }

    public static void main(String args[])
	{

        double startKM1 = 100;
        double endKM1 = 200;
        double liters1 = 20;

        double startKM2 = 200;
        double endKM2 = 400;
        double liters2 = 15;

        Car car1 = new Car(startKM1, endKM1, liters1);
        Car car2 = new Car(startKM2, endKM2, liters2);

        System.out.println("The fuel consimption for the first car is: " + car1.computeConsumption() + "L/100 KM");
        System.out.println("The fuel consimption for the second car is: " + car2.computeConsumption() + "L/100 KM");

    }

}