package regular;

public class ex5 {
    public static void main(String[] args){
        int[] v1 = {8, 12, 37, 52, 58};
        int[] v2 = {6, 11, 33, 57, 98};
        int[] v_merged = new int[v1.length + v2.length];
        int index = 0;

        for(int i = 0; i < v1.length; i++){
            v_merged[index] = v1[i];
            index++;
        }

        for(int i = 0; i < v2.length; i++){
            v_merged[index] = v2[i];
            index++;
        }

        //testing the new merged array
        for(int i = 0; i < v_merged.length; i++){
            System.out.print(v_merged[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < v_merged.length; i++){
            for(int j = i + 1 ; j < v_merged.length; j++){
                if(v_merged[j] < v_merged[i]){
                    int aux = v_merged[i];
                    v_merged[i] = v_merged[j];
                    v_merged[j] = aux;
                }
            }
            System.out.print(v_merged[i] + " ");
        }
        System.out.println();
    }
}
