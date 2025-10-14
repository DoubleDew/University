package Lab_2;

public class ex2 {
    public static void main(String[] args){
        // Random r = new Random();
        int[] v = {15, 56, 859, 1, 76, 59, 1000, 4};
        int sum = 0;

        for(int i = 0; i < v.length; i++){
            System.out.print(v[i] + " ");
        }
        System.out.println();
        
        for (int i = 0; i < v.length; i++){
            if(v[i] % 2 == 0){
                sum += v[i];
            }
        }

        System.out.println("The sum of the even numbers in the array is: " + sum);
    }
}
