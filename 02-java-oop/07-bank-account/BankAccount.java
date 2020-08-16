import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    //static attributes
    public static int numberOfAccounts = 0;
    public static int totalInEachAccount = 0;

    //Create a private method that returns a random ten digit account number
    static String randomAccountNumber() {
        //return a 10 digit random number
        String rand10 = "";
        Random r = new Random();
		for(int i = 0; i < 10; i++) {
			rand10 += r.nextInt(10);
		}
        return rand10;
    }
    
    //In the constructor, call the private method from above so that each user has a random ten digit account.
    public BankAccount() { 
        this.accountNumber = BankAccount.randomAccountNumber();
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        BankAccount.numberOfAccounts++;
    }

    //Create a getter method for the user's checking account balance.
    public double getCheckingBalance(){
        return this.checkingBalance;
    }

   //Create a getter method for the user's saving account balance.
    public double savingsBalance(){
        return this.savingsBalance;
    }

    //Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored
    public void depositMoney(double amount, String account){
        if (account.equals("savings"))
			this.savingsBalance += amount;
		else if (account.equals("checking"))
			this.checkingBalance += amount;
		    BankAccount.totalInEachAccount += amount;
    }
    
    // Create a method to withdraw money from one balance. 
    //Do not allow them to withdraw money if there are insufficient funds.
    public void withdrawMoney(double amount, String account) {
        if (account.equals("savings")) { 
            if(this.savingsBalance - amount >= 0) {
                this.savingsBalance -= amount;
            } else if (account.equals("checking")) {
                // check if enough in account
                if(this.checkingBalance - amount >= 0) {
                    this.checkingBalance -= amount;
                    BankAccount.totalInEachAccount += amount;
                }
            }
        }
    }
    //Create a method to see the total money from the checking and saving.
    public void displayTotalCheckingSavings(){
        System.out.println(String.format("Total Savings %2f, Checking %2f ", this.savingsBalance, this.checkingBalance));
    }
}