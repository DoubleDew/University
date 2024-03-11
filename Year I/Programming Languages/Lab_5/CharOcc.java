import java.util.Scanner;

public class CharOcc
{	
	public static int countCharsIterative(String s, char c)
	{
		int count=0;
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)==c)
				count++;
		return count;
	}
	public static int countCharsRecursive(String s, char c,int index)
	{
		if(index >= s.length())
			return 0;
		int count = 0;
		if(s.charAt(index)==c)
			count++;
		return count + countCharsRecursive(s,c,index+1);
	}
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String st = scan.nextLine();
		System.out.println("Enter the character: ");
		char ch = scan.next().charAt(0);
		System.out.println("Iterative");
		System.out.println("The number of occurrences of the character in the string is " + countCharsIterative(st,ch));
		System.out.println("Recursive");
		System.out.println("The number of occurrences of the character in the string is " + countCharsRecursive(st,ch,0));
	}
}