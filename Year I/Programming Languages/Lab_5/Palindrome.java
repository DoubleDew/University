import java.util.Scanner;

public class Palindrome 
{
    public static boolean palindromeIterative(String s)
	{
        String clean = s.replaceAll("\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) 
		{
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }
	public static boolean palindromeRecursive(String text)
	{
        String clean = text.replaceAll("\s+", "").toLowerCase();
        return palindromeRecursiveTest(clean,0, clean.length()-1);
    }
    private static boolean palindromeRecursiveTest(String text, int forward, int backward)
	{
        if (forward == backward)
            return true;
        if ((text.charAt(forward)) != (text.charAt(backward)))
            return false;
        if (forward < backward + 1)
            return palindromeRecursiveTest(text, forward + 1, backward - 1);
        return true;
    }
    public static void main(String args[])
	{
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String s = scan.nextLine();
        System.out.println("Is s a palindrome? (iterative)");
        if(palindromeIterative(s)) 
			System.out.println("Yes");
        else 
			System.out.println("No");
        System.out.println("Is s a palindrome? (recurive)");
        if(palindromeRecursive(s)) 
			System.out.println("Yes");
        else
			System.out.println("No");
    }
}