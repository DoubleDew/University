import javax.swing.*;
class Divisor
{
	public static void main(String args[])
	{
		int n1,n2,a=1;
		n1= Integer.parseInt(JOptionPane.showInputDialog("Input an n = "));
		n2= Integer.parseInt(JOptionPane.showInputDialog("Input an n = "));
		for (int i = 1; i <= n1 && i <= n2; i++) 
			if (n1 % i == 0 && n2 % i == 0) 
				a=i;
		System.out.println(a);
	}
}