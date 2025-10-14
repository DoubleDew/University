package Lab_2;

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

        for(int i = 0; i < v_merged.length-1; i++){
            if(v_merged[i] > v_merged[i+1]){
                int aux = v_merged[i];
                v_merged[i] = v_merged[i+1];
                v_merged[i+1] = aux;
            }
            System.out.print(v_merged[i] + " ");
        }
        System.out.println();
    }
}
