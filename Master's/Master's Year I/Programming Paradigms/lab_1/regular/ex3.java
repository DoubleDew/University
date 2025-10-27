package regular;
import java.util.*;

public class ex3 {

    static int[] vowelOrNot(String str){
        int vowels = 0;
        int consonants = 0;
        for(int i = 0; i < str.length(); i++){
        
            char c = str.charAt(i);
            if(!Character.isLetter(c))
                continue; // skip spaces, punctuation, digits

            if( str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U')
                vowels++;
            else
                consonants++;
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str =  scan.nextLine();
        scan.close();

        int[] counts = vowelOrNot(str);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }
}
