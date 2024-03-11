package HW2;
import java.lang.Math;
class Calc
{
	public static void main(String args[])
	{
		double a,b;
		a=(1.0/2.0+3.0/17.0*0.5/2.0+Math.sqrt(1.0/2.0))/(2.0/(7.0*7.0*7.0));
		b=((9.0/2.0)+(3.0/4.0))/(1.0/(3.0*3.0*3.0));
		double res=a*b;
		System.out.println(res);
	}
}