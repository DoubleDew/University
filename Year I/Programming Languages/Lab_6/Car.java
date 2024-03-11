class Car
{
    private double startKM;
    private double endKM;
    private double liters;

    public Car(double startOdo, double endOdo, double litersUsed)
	{
        this.startKM = startOdo;
        this.endKM = endOdo;
        this.liters = litersUsed;
    }

    public double computeConsumption()
	{
        double totalKM = endKM - startKM;
        double consumption = totalKM / liters;
        return consumption;
    }
}