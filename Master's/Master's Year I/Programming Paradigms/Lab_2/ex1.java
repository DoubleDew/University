package Lab_2;

// import java.util.*;

class ex1{
    public static void main(String[] args){
        int[] v = {15, 56, 859, 1, 76, 59, 1000, 4};
        int max = v[0];
        int min = v[0];

        for(int i = 0; i < v.length; i++){
            System.out.print(v[i] + " ");
        }
        System.out.println();
        
        for (int i = 0; i < v.length; i++){
            if(v[i] > max){
                max = v[i];
            }

            if(v[i] < min){
                min = v[i];
            }
        }

        System.out.println("Max number in the array is:" + max);
        System.out.println("Min number in the array is:" + min);
    }
}