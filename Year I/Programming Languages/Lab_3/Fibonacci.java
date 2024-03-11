import java.util.Scanner;
import javax.swing.*;
class Fibonacci
{	
	public static void main(String args[])
	{
		int a1=0,a2=1,a3;
		Scanner count = new Scanner(System.in);
		System.out.println("Input number count: ");
		int n = count.nextInt();
		if(n>0)
		{
			System.out.println(a1);
			System.out.println(" " +a2);
			while(n!=0)
			{
				a3=a1+a2;
				System.out.println(" " + a3);
				a1=a2;
				a2=a3;
				n--;
			}
		}
		else 
			System.out.println("Wrong Value! Please input a positive number!");
	}
}