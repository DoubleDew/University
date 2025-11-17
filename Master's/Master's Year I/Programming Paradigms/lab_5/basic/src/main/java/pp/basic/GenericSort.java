package pp.basic;

public class GenericSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        T temp;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length-1; j++){
                if(arr[j].compareTo(arr[j+1]) > 0){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}