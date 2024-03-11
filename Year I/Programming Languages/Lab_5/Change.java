import java.util.Scanner;

public class Change
{
	public static void mod(String s)
	{	
		int last=s.length() -1;
		String sfin = "";
		for(int i=0;i<last;i++)
		{
			sfin = sfin + s.charAt(i) + s.charAt(last);
			last--;
		}
		System.out.println(sfin);
	}
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		mod(s);
	}
}