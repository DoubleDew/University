package advanced;

public class ex2 {
    //LeetCode: https://leetcode.com/problems/can-place-flowers/description/

    public static boolean canPlaceFlowers(int[] flowerbed, int n){
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++){
            if(i == 0 && flowerbed[i] != 1){
                if(flowerbed[i+1] == 0){
                    count++;
                    flowerbed[i] = 1;
                }
            }
            else 
                if(i == flowerbed.length - 1 && flowerbed[i] != 1){
                    if(flowerbed[i-1] == 0){
                        count++;
                        flowerbed[i] = 1;
                    }
                }
            else
                if(i != 0 && i != flowerbed.length - 1 && flowerbed[i] != 1){
                    if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                        count++;
                        flowerbed[i] = 1;
                    }
                }
        }

        if(count < n)
                return false;
            else
                return true;
    }

    public static void main(String[] args){
        int[] flowerbed1 = {1, 0, 0, 0, 1};
        int[] flowerbed2 = {0, 0, 0, 0, 0};
        int[] flowerbed3 = {0, 1, 1, 1, 0};

        System.out.println(canPlaceFlowers(flowerbed1, 1));
        System.out.println(canPlaceFlowers(flowerbed1, 2));
        System.out.println(canPlaceFlowers(flowerbed2, 1));
        System.out.println(canPlaceFlowers(flowerbed3, 1));
    }    
}
