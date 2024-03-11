import java.util.Scanner;
public class PrimeNr
{
	public static boolean isPrime(int n)
	{ 
		for(int i=2;i<=n/2;i++)
			if (n%i==0)
				return false;
		return true;
	}
	public static void genPrimes(int n)
	{
		int ok;
		for(int i=2;i<=n;i++)
		{
			ok=1;
			for(int j=2;j<=i/2;j++)
				if (i%j==0)
					ok=0;
			if(ok==1)
				System.out.print(i + " ");
		}
	}
	public static boolean allPrimeDivisors(int n)
	{
		for(int d=2;d<=n/2;d++)
			if(n%d==0)
				if (isPrime(d) == false)
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
		System.out.println("All prime numbers less than n are: ");
		genPrimes(x);
		System.out.println(" ");
		System.out.println("Are all divisors of n prime?");
		System.out.println(allPrimeDivisors(x));
	}
}