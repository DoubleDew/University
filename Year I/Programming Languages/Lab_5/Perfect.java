import java.util.Scanner;

public class Perfect
{
	public static boolean isPerfect(int x)
	{
		int sum = 0, i=1;
		while(i<=x/2)
		{
			if(x%i==0)
				sum += i;
			i++;
		}
		if(sum == x)
			return true;
		else 
			return false;
	}
	public static void main(String [] args)
	{
		int x;
		Scanner scan = new Scanner(System.in);
		System.out.println("x = ");
		x = scan.nextInt();
		System.out.println(isPerfect(x));
		 for(int i = 1; i <= x; i++)
            if(isPerfect(i)) System.out.print(i + " ");
	}
}