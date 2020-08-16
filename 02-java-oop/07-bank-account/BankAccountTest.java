public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount bankacct1 = new BankAccount();

        bankacct1.depositMoney(10, "savings");
        bankacct1.depositMoney(20, "savings");
        bankacct1.displayTotalCheckingSavings();

        //display the number of accounts
        System.out.println(BankAccount.numberOfAccounts);

        //instantiate a new bank account
        BankAccount bankAccount2 = new BankAccount();
        BankAccount bankAccount3 = new BankAccount();
        BankAccount bankAccount4 = new BankAccount();

        bankAccount2.depositMoney(100, "savings");
        bankAccount2.depositMoney(200, "checking");
        bankAccount2.displayTotalCheckingSavings();

        System.out.println(BankAccount.totalInEachAccount);

        //should be 4 accounts now
        System.out.println(BankAccount.numberOfAccounts);

        //display random account number
        System.out.println(BankAccount.randomAccountNumber());
    }
}