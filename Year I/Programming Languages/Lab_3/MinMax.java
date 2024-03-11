public class MinMax
{
	public static void main(String[] args)
	{
		int[] a={4, 2, 1, 7, 0, 8, 3, 9, 6, 5};
		int min=a[0];
		int max=a[0];
		for(int i=1;i<=a.length-1;i++)
		{	
			if(min>a[i])
				min=a[i];
			if(max<a[i])
				max=a[i];
		}
		System.out.println("The minimum is " + min + " and the maximum element is " + max);
	}
}