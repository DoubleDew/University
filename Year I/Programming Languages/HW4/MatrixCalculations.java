/*package HW4;
import java.util.Scanner;

public class MatrixCalculations
{
    public static int sumMainDiagonal(int m[][])
	{
        int d = 0;
        for(int a = 0; a < m.length; a++)
		{
            for(int b = 0; b < m[0].length; b++)
                if (a == b) 
					d = d + m[a][b];
        }
        return d;
    }
    public static int sumUnderMainDiagonal(int m[][]) 
	{
        int s = 0;
        for (int i = 0; i < m.length; i++) 
            for (int j = i; j >= 0; j--) 
                s += m[i][j];
        return s;
    }
    public static int[][] matrixMultiplication(int a[][], int b[][])
	{
        if(a.length != b.length || a[0].length != b[0].length) 
			System.out.println("The multiplication can't be done");
        int c[][] = new int[a.length][b[0].length];
        for(int i = 0; i < b.length; i++)
		{
            for(int j = 0; j < b.length; j++)
			{
                c[i][j] = 0;
                for(int k = 0; k < b.length; k++)
				{
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
    public static void main(String args[])
	{
        Scanner scan = new Scanner(System.in);

        System.out.println("Write the number of columns for matrix m:");
        int columnsM = scan.nextInt();
        System.out.println("Write the number of rows for matrix m:");
        int rowsM = scan.nextInt();
        int[][] m = new int[rowsM][columnsM];
        System.out.println("matrix m:");
        for (int i = 0; i < rowsM; i++) 
			for (int j = 0; j < columnsM; j++) 
                m[i][j] = scan.nextInt();
        System.out.println("Sum of main diagonal is " + sumMainDiagonal(m) + ".");
		System.out.println("The sum of the elements under the main diagonal is " + sumUnderMainDiagnal(m) + ".");
        //matrix m with the 2 main diagonal related problems
		
		System.out.println("Write the number of columns for matrix a:");
        int columnsA = scan.nextInt();
        System.out.println("Write the number of rows for matrix a:");
        int rowsA = scan.nextInt();
        int[][] a = new int[rowsA][columnsA];
        System.out.println("Write matrix a:");
        for (int i = 0; i < rowsA; i++) 
            for (int j = 0; j < columnsA; j++) 
                a[i][j] = scan.nextInt();
		//matrix a
		
        System.out.println("Write the number of columns for matrix b:");
        int columnsB = scan.nextInt();
        System.out.println("Write the number of rows for matrix b:");
        int rowsB = scan.nextInt();
        int[][] b = new int[rowsM][columnsM];
        System.out.println("matrix b:");
        for (int i = 0; i < rowsB; i++) 
            for (int j = 0; j < columnsB; j++)
                b[i][j] = scan.nextInt();
		//matrix b
		
        System.out.println("The multiplication matrix is:");
        int[][] c = matrixMultiplication(a, b);
        for(int i = 0; i < c.length; i++)
            for(int j = 0; j < c[0].length; j++)
                System.out.print(c[i][j] + " ");
		//multiplication
        scan.close();
    }
}*/