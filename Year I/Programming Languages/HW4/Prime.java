package HW4;
import java.util.Scanner;
public class Prime
{
	public static boolean isPrime(int n)
	{ 
		for (int i=2;i<=n/2;i++)
			if (n%i==0)
				return false;
		return true;
	}
	public static void main (String [] args)
	{
		int x;
		Scanner scan = new Scanner(System.in);
		System.out.println("x = ");
		x = scan.nextInt();
		System.out.println(isPrime(x));
		scan.close();
	}
}