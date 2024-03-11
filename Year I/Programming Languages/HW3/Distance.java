package HW3;
import java.lang.Math;
import java.util.Scanner;
public class Distance
{
	public static double distance(double x1, double y1, double x2, double y2)
	{
		double dif1 = (x2-x1) * (x2-x1);
		double dif2 = (y2-y1) * (y2-y1);
		return 	Math.sqrt(dif1 + dif2);
	}
	public static void main(String [] args)
	{
		double x1,y1,x2,y2,dist;
		Scanner value = new Scanner(System.in);
		System.out.println("x1 = ");
		x1 = value.nextDouble();
		System.out.println("y1 = ");
		y1 = value.nextDouble();
		System.out.println("x2 = ");
		x2 = value.nextDouble();
		System.out.println("y2 = ");
		y2 = value.nextDouble();
		dist = distance(x1,y1,x2,y2);
		System.out.println("Distanta dintre cele 2 puncte este: " + dist);
		value.close();
	}
}