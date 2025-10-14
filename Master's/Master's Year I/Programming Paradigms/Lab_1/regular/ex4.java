package regular;
import java.util.*;

class ex4{
    public static  void main(String [] args){
        Random r = new Random();
        int[][] a = new int[5][6];

        System.out.println("\nMatrix:");
        for(int i = 0; i < 5 ; i++){
            for(int j = 0; j < 6; j++){
                a[i][j] = r.nextInt(101);
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for(int i = 0; i < 5; i++){
            int sumRows = 0;
            
            for(int j = 0; j < 6; j++){
                sumRows += a[i][j];
            }
            System.out.println("The sum of row " + (i + 1) + " is: " + sumRows);
        }

        System.out.println();
        for(int j = 0; j < 6; j++){
            int sumCols =0;
            for(int i = 0; i < 5; i++){
                sumCols += a[i][j];
            }
            System.out.println("The sum of column " + (j + 1) + " is: " + sumCols);
        }
    }
}
