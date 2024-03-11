package HW2;
import java.util.Scanner;
public class Names{
public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		String firstname = scan.nextLine();
        String lastname = scan.nextLine();
        String cnp = scan.nextLine();
        System.out.println(firstname + lastname + ", " + cnp);
        String password = firstname.substring(0,2).toLowerCase() + lastname.substring(lastname.length()-2,lastname.length()).toUpperCase();
        System.out.println("Your password is: " + password);
        scan.close();
    }
}