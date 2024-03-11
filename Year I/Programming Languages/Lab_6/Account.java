class Account 
{
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accNumber, String accHolder, double bal)
	{
        this.accountHolder = accHolder;
        this.accountNumber = accNumber;
		this.balance = bal;
    }

    public double getBalance()
	{
		return balance;
    }

    public void processDeposit(double amount)
	{
		balance += amount;
    }

    public void processCheck(double amount)
	{
		if(balance < 10000) 
			amount += 30;
		balance -= amount;
    }
}