import java.util.Scanner;

public class LongSeq
{
	public static void main(String [] args)
	{
		int[] a=new int[100];
        int n, g=0, t=0,p=0,m=0;
        Scanner scan = new Scanner(System.in);
		System.out.println("n= ");
        n=scan.nextInt();
        for(int i=0;i<n;i++)
        {
			a[i]=scan.nextInt();
            if(a[i]>=0)
                g++;
            else
            {
				if(g>m)
                {
					m=g;
					t=i-g;
				}
             g=0;
            }
		}
        if(g>m)
             m=g;
        System.out.print("index " + t + " lungime " + m);
	}
}