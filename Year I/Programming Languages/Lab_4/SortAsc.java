import java.util.Scanner;

public class SortAsc
{
    public static void merge(int[] a, int[] b, int n, int m, int[] c)
    {
        int i = 0, j = 0, k = 0;
        while (i < n && j < m)
        {
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }
            while (i < n)
            c[k++] = a[i++];

            while (j < m)
            c[k++] = b[j++];
    }
    public static void main (String [] args)
    {
        int[] a = {13, 65, 67, 91};
        int n = a.length;
        int[] b = {3, 14, 22, 45, 51, 79};
        int m = b.length;
        int[] c = new int[n+m];
        merge(a, b, n, m, c);
        for (int i=0; i < n+m; i++)
            System.out.print(c[i] + " ");
    }
}