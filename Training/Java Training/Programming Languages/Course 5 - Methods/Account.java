public class Account{
    // - = private
    // # = protected
    // + = public

    private String IBAN; 
    private String bank;
    private double amount;

    public Account(String IBAN, String bank, double amount){
        this.IBAN = IBAN;
        this.bank = bank;
        this.amount = amount;
    }

    protected void deposit(double a){
        this.amount = this.amount + a;
        System.out.println("My new amount of money = " + this.amount);
    }

    protected void withdraw(double a){
        if(this.amount >= a){
            this.amount -= a;
            System.out.println("My new amount of money = " + this.amount);
        }
        else {
            System.out.println("You don't have enough money to withdraw");
        }
    }

    public static void main(String []args){
        Account a = new Account("RO091BCR3254", "nigga bank from the hood", 1000);
        a.withdraw(520);
    }


    //Getters and Setters
    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String iBAN) {
        IBAN = iBAN;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}