class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displaySavingsAccountInfo() {
        System.out.println("Savings Account Info:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + getBalance());
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("12345", "John Doe", 5000);
        account1.displayAccountInfo();

        account1.setBalance(6000);
        System.out.println("Updated Balance: " + account1.getBalance());

        SavingsAccount savingsAccount1 = new SavingsAccount("67890", "Alice Smith", 10000);
        savingsAccount1.displaySavingsAccountInfo();
    }
}
