package regular;
import java.util.*;

class SecondLab2{

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your first name: ");
        String fname = scan.nextLine();

        System.out.println("Enter your last name: ");
        String lname = scan.nextLine();

        /* 
            -- asked for cnp to be read, but it's not used anywhere --
            System.out.println("Enter your CNP: ");
            String cnp = scan.nextLine();  
        */
        
        scan.close();
        
        String part1 = fname.substring(0, 2).toLowerCase();
        String part2 = lname.substring(lname.length() - 2).toUpperCase();

        String pass = part1 + part2;
        
        
        System.out.println(pass);
    }
}