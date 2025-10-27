package com.example;

import java.util.Random;
//WIP
public class Guess {

    public int guessing(int num, int pick){
        if(num > pick){
            return -1;
        } else if (num < pick){
            return 1;
        } else {
            return 0;
        }
    }

    public int guessNumberIterative(int n){
        int low = 1, high = n;
        Random rand = new Random();
        int pick = rand.nextInt(n);

        while(low <= high){
            int mid = low + (high - low) / 2;
            int result = guessing(mid, pick); 
            if(result == 0){
                return mid;
            } else if (result < 0){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int guessNumberRecursive(int n){
        Random rand = new Random();
        int pick = rand.nextInt(n);
        return guessHelper(1, n, pick);
    }

    private int guessHelper(int low, int high, int pick){
        if(low > high)
            return -1;
        
        int mid = low + (high - low) / 2;
        int result = guessing(mid, pick);
        
        if(result == 0)
            return mid;
        else if (result < 0)
            return guessHelper(low, mid - 1, pick);
        else
            return guessHelper(mid + 1, high, pick);
    }
}