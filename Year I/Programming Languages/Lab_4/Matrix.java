import java.util.Random;    
import java.util.Scanner;

public class Matrix
{
	public static void main(String [] args)
	{
		Random r=new Random();
		int[][] a=new int[100][100];
		int n, g=0, t,p=0,m;
		Scanner scan = new Scanner(System.in);
		for(int i=1;i<=5;i++)
			for(int j=1;j<=7;j++)
				a[i][j]=r.nextInt(100);
		for(int i=1;i<=5;i++)
		{   
			for(int j=1;j<=7;j++)
				System.out.print(a[i][j]+ " ");
			System.out.println("");
		}
		m=a[1][1];
		for(int i=1;i<=5;i++)
		{ 
			t=a[i][1];
			for(int j=1;j<=7;j++)
			{
				if(a[i][j] > m)
					m=a[i][j];
				if(a[i][j] > t)
					t=a[i][j];
			}
			System.out.print(t+ " ");
		}
		System.out.print("max element: " + m);
	}
}