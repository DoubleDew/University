import java.util.Scanner;

public class Triplets
{
 public static void Triplets(int a[], int n, int s)
    {
        for (int i = 0; i < n - 2; i++) 
            for (int j = i + 1; j < n - 1; j++) 
                for (int k = j + 1; k < n; k++) 
                    if (a[i] + a[j] + a[k] == s) 
                        System.out.println( a[i] + " " + a[j] + " " + a[k]);
		
    }
 
    public static void main(String[] args)
    {
        int a[] = {1, 6, 3, 0, 8, 4, 1, 7};
        int n = a.length;
        int s;
        Scanner console = new Scanner(System.in);
        System.out.println("Introduceti suma: ");
            s = console.nextInt();
        Triplets(a, n, s);
    }
}