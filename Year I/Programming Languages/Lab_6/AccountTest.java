class AccountTest extends Account
{
    public AccountTest(String accNumber, String accHolder, double bal) 
	{
        super(accNumber, accHolder, bal);
    }

    public static void main (String [] args)
	{
        String accNumber1 = "420DMD69";
        String accNumber2 = "684GHR12";

        String accHolder1 = "Danut Deaconu";
        String accHolder2 = "Jane Doe";

        double bal1 = 18000;
        double bal2 = 3200;

        Account account1 = new Account(accNumber1, accHolder1, bal1);
        Account account2 = new Account(accNumber2, accHolder2, bal2);

        System.out.println("The balance for the first account is: " + account1.getBalance());
        System.out.println("The balance for the second account is: " + account2.getBalance());

        account1.processDeposit(2000);
        account2.processCheck(1500);

        System.out.println("New balance for the first account is: " + account1.getBalance());
        System.out.println("New balance for the second account is: " + account2.getBalance());
    }
}