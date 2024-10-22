import java.util.*;
// import java.util.Random;

public class SortedArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a[] = new int[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = scan.nextInt();
        }

        System.out.println();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println();

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        System.out.println();

        scan.close();
    }
}

// public class SortedArray {
//     public static void main(String[] args) {
//         int a[] = new int[10];
//         Random r = new Random();

//         for ( int i = 0; i < a.length; i++){
//             a[i] = r.nextInt(100);
//         }

//         System.out.println();
//         for (int i = 0; i < a.length; i++) {
//             System.out.print(a[i] + " ");
//         }
//         System.out.println();

//         boolean changed = false;
//         do {
//             changed = false;
//             for (int i = 0; i < a.length - 1; i++) {
//                 if (a[i] > a[i + 1]) {
//                     int temp = a[i];
//                     a[i] = a[i + 1];
//                     a[i + 1] = temp;
//                     changed = true;
//                 }
//             }
//         } while (changed);

//         for (int i = 0; i < a.length; i++) {
//             System.out.print(a[i] + " ");
//         }

//         System.out.println();
//     }
// }