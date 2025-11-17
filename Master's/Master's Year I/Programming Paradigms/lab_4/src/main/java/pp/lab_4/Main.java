package pp.lab_4;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Client client1 = new Client("Deaconu Mircea-Dan", LocalDate.of(2002, 2, 20), "50123456789");
        Client client2 = new Client("Tiberiu-Adrian Petre", LocalDate.of(2002, 4, 20), "50987654321");

        DebitAccount debit = new DebitAccount("RO00BANK0001", 1000);
        CreditAccount credit = new CreditAccount("RO00BANK0002", 1000000000, 500);

        client1.addAccount(debit);
        client1.addAccount(credit);

        debit.deposit(300);
        debit.withdraw(500);
        debit.withdraw(2000);

        debit = new DebitAccount("RO00BANK0003", 10000);
        credit = new CreditAccount("RO00BANK0004", 159, 2000);

        credit.withdraw(400);
        credit.withdraw(200);

        client1.addAccount(new DebitAccount("RO00BANK0001", 9999));
        System.out.println("Accounts:");
        client1.getAccounts().forEach(acc -> System.out.println(acc.getIBAN() + " - " + acc.getAmmount()));
        client1.removeAccount("RO00BANK0001");
        client1.removeAccount("RO00BANK9999");
        System.out.println("\nAfter removal:");
        client1.getAccounts().forEach(acc -> System.out.println(acc.getIBAN() + " - " + acc.getAmmount()));

        client2.addAccount(debit);
        client2.addAccount(credit);

        List<Account> accounts = client2.getAccounts();
        accounts.addAll(client1.getAccounts());
        accounts = accounts.stream().sorted().toList();
        
        System.out.println("\nSorted accounts:");
        for (Account account : accounts)
            System.out.println(account.getIBAN() + " - " + account.getAmmount());

        System.out.println();
        System.out.println("********************************");
        System.out.println();

        List<Person> people = new ArrayList<>();
    
        people.add(new Person("Deaconu Mircea-Dan", LocalDate.of(2002, 2, 20), "Male", 178));
        people.add(new Person("Deaconu Mircea-Dan", LocalDate.of(2002, 2, 21), "Female", 180));
        people.add(new Person("Deaconu Mircea-Dan", LocalDate.of(2002, 2, 21), "Female", 195));
        people.add(new Person("Deaconu Mircea-Dan", LocalDate.of(2002, 2, 21), "Male", 195));
        people.add(new Person("Statioiu Maria-Luiza", LocalDate.of(2004, 2, 15), "Female", 171));
        people.add(new Person("Petre Tiberiu-Adrian",  LocalDate.of(2002, 9, 21), "Male", 178));
        people.add(new Person("Ionita Alexandru-Mihail",  LocalDate.of(2003, 01, 10), "Male", 250));
        
        people = people.stream().sorted().toList();

        for(Person person : people)
            System.out.println(person.toString() + "\n");

        people.get(0).store("people.txt");
    }
}