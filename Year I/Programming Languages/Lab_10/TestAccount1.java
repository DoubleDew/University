public class TestAccount1 
{
    public static void main(String[] args) 
    {
        Account[] account = new Account[4];

        account[0] = new Account(4000,"Deaconu");
        account[1] = new Account(3000, "Petrescu");

        account[2] = new SavingsAccount(1000,"Eftenie", 10);
        account[3] = new SavingsAccount(5550, "Statoiu", 20);

        for (int i = 0; i < 4; i++)
            System.out.println(account[i]);

        for (int i = 0; i < 4; i++) 
        {
            if (account[i] instanceof SavingsAccount)
            {
                ((SavingsAccount) account[i]).applyInterest();
                System.out.println(account[i]);
            }
        }

        ((Account) account[0]).withdrawal(50);
        ((Account) account[1]).withdrawal(100);

        System.out.println(account[0]);
        System.out.println(account[1]);
    }
}
