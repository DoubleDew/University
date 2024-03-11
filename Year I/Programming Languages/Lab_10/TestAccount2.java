public class TestAccount2
 {
    public static void main(String[] args)
    {
        Account account[] = new Account[2];
        SavingsAccount savings[] = new SavingsAccount[2];

        account[0] = new Account(4000,"Deaconu");
        account[1] = new Account(3000, "Petrescu");

        savings[0] = new SavingsAccount(1000,"Eftenie", 10);
        savings[1] = new SavingsAccount(5550, "Statoiu", 20);

        for(int i = 0; i < 2; i++)
        {
            System.out.println(account[i]);
            System.out.println(savings[i]);
        }

        for(int i = 0; i < 2; i++)
        {
            savings[i].applyInterest();
            System.out.println(savings[i]);
        }

        account[0].withdrawal(50);
        account[1].withdrawal(100);

        System.out.println(account[0]);
        System.out.println(account[1]);
    }
}