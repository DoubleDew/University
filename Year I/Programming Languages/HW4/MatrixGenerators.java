package HW4;
import java.util.Scanner;

public class MatrixGenerators
{
    public static int[][] matrix1(int size)
	{
        int m1[][] = new int[size][size];
        int index = 1;
        for(int i = 0; i < size; i++)
		{
            for(int j = 0; j < size; j++)
			{
                m1[i][j] = index;
                index++;
            }
        }
        return m1;
    }
    public static int[][] matrix2(int size) {
        int m2[][] = new int[size][size];
        int index = 1;
        for (int i = 0; i < size; i++) 
		{
            for (int j = 0; j < size; j++) 
			{
                m2[j][i] = index;
                index++;
            }
        }
        return m2;
    }
    public static void main(String [] args)
	{
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the matrixes: ");
        int size = scan.nextInt();
        int[][] matrix1 = new int[size][size];
        matrix1 = matrix1(size);
        for(int i = 0; i < size; i++)
		{
            for(int j = 0; j < size; j++)
			{
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        int[][] matrix2 = new int[size][size];
        matrix2 = matrix2(size);
        for(int i = 0; i < size; i++)
		{
            for(int j = 0; j < size; j++)
			{
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        scan.close();
    }
}