import java.util.*;

public class RandomArray {
    public static void main(String[] args) {
        int a[] = new int[10];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100);
        }

        // display the array
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        int min, max;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
            if (a[i] < min)
                min = a[i];
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

        System.out.println("************************************");


        int m[][] = new int[10][10];
        for (int line = 0; line < m.length; line++ ){
            for (int column = 0; column < m[line].length; column++) {
                m[line][column] = r.nextInt(100); 
            }
        }

        for (int line = 0; line < m.length; line++ ){
            for (int column = 0; column < m[line].length; column++) {
                System.out.print(m[line][column] + " "); 
            }
            System.out.println();
        }
        
    }
}
