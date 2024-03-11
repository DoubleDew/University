import java.util.Scanner;

public class Occurrences
{
	public static int match(String st1, String st2)
	{
		int lastIndex = 0, count = 0;
		while(lastIndex != -1)
		{
			lastIndex = st2.indexOf(st1, lastIndex);
			if(lastIndex != -1)
			{
				count++;
				lastIndex += st1.length();
			}
		}
		return count;
	}
    public static void main(String [] args)
	{
        Scanner scan = new Scanner(System.in);
        System.out.println("first string:");
        String st1 = scan.nextLine();
        System.out.println("second string:");
        String st2 = scan.nextLine();
        System.out.println("number of occurrences: ");
        System.out.println(match(st1, st2));
    }
}