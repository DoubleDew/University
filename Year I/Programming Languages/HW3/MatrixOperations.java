package HW3;
import java.util.Scanner;
//import java.lang.Math;
public class MatrixOperations
{
	public static void valueIn(Scanner scan,double m[][],int r,int col)
    {
      for(int i=0;i<r;i++)
         for(int j=0; j<col;j++)
            m[i][j] = scan.nextInt();
    }
	public static void valueOut(double m[][],int r,int col)
    {
      for(int i=0;i<r;i++)
         for(int j=0;j<col;j++)
            System.out.print(m[i][j] + " ");
      System.out.println();
    }
	public static double[][] matrixAdd(double m1[][],double m2[][],int r,int col)
	{
		double[][] c = new double[r][col];
		for(int i=0;i<r;i++)
			for(int j=0;j<col;j++)
				c[i][j] = m1[i][j] + m2[i][j];
		return c;
	}
	public static double matrixDiagSum(double m[][],int r,int col)
	{
		double ds=0;
		for(int i=0;i<r;i++)
			for(int j=0;j<col;j++)
				if (i==j)
					ds+=m[i][j];
		return ds;
	} 
	public static void main(String[] args)
	{
		int r,col;
		double ds;
		Scanner scan = new Scanner(System.in);
		System.out.println("number of rows = ");
		r = scan.nextInt();
		System.out.println("number of columns = ");
		col = scan.nextInt();
		double[][] m1 = new double[r][col];
		double[][] m2 = new double[r][col];
		double[][] sum = new double[r][col];
		System.out.println("Matrix 1 : ");
		valueIn(scan,m1,r,col);
		System.out.println("Matrix 2 : ");
		valueIn(scan,m2,r,col);
		sum = matrixAdd(m1,m2,r,col);
		System.out.println("The sum of the 2 matrices is: ");
		valueOut(sum,r,col);
		ds = matrixDiagSum(m1,r,col);
		System.out.println("The sum of the elements on the first diagonal: " + ds);
		scan.close();
	}
}