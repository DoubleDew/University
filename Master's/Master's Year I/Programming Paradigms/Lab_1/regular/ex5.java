package regular;
import java.util.*;


public class ex5 {
    public static void main(String[] args){
        Random r = new Random();
        int[] v = new int[100];

        for(int i = 0; i < 100; i++)
            v[i] = r.nextInt(101);
        
        for(int i = 0; i < 100; i++)
            System.out.print(v[i] + " ");

        int count = 0;
        int long_succ = 0;
        int great_diff = 0;

        for (int i = 0; i < 100; i++) {
            if (v[i] % 2 == 0) {
                count++;
                if (count > long_succ) long_succ = count;
            } else {
                count = 0;
            }

            if (i < 99) {
                int diff = v[i] - v[i + 1];
                if (diff > great_diff) 
                    great_diff = diff;
            }
        }

        System.out.println("\n");
        System.out.println("The length of the longest succession of even numbers is: " + long_succ);
        System.out.println("The greatest difference between 2 succesive numbers is: " + great_diff);
    }
}
