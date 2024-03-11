package HW1;
public class Error 
{
	public static void main (String[] args)
	{
		int a;
		a=5;
		int b=2; //The variable 'b' was not initialized. "Error.java:9: error: variable b might not have been initialized"
		int c;
		c=a/b;
		System.out.println(c);
	}
}
