package Lab_2;

public class ex4 {

    public static void setZeroes(int[][] a){
        int n = a.length;
        System.out.println("Rows: " + n);
        int m = a[0].length;
        System.out.println("Columns: " + m);

        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rows[i] == true || cols[j] == true){
                    a[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args){
        // Random r = new Random();
        // Scanner scan = new Scanner(System.in);

        int[][] a = { 
                        { 9, 1, 2, 7 },
                        { 3, 4, 0, 2 },
                        { 1, 3, 1, 5 }
                    };

        setZeroes(a);
        
        System.out.println("New matrix: ");
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
