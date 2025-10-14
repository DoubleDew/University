package advanced;
import java.util.Arrays;

public class ex1 {
    public static boolean[] kidsWithCandies(int[] candies, int extraCandies){
        boolean[] result = new boolean[candies.length];

        int maxCandies = 0;
        for(int i = 0; i < candies.length; i++){
            if(candies[i] > maxCandies){
                maxCandies = candies[i];
            }
        }

        for(int i = 0; i < candies.length; i++){
            if((candies[i] + extraCandies) >= maxCandies){
                result[i] = true;
            }
            else{
                result[i] = false;
            }
        }

        return result;
    }
    
    public static void main(String[] args){
        int[] kid1 = {2,3,5,1,3};
        int[] kid2 = {4,2,1,1,2};
        int[] kid3 = {12,1,12};

        System.out.println(Arrays.toString(kidsWithCandies(kid1, 3)));
        System.out.println(Arrays.toString(kidsWithCandies(kid2, 1)));
        System.out.println(Arrays.toString(kidsWithCandies(kid3, 10)));
    }
}
