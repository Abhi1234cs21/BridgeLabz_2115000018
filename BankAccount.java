class BankAccount {
    private static String bankName = "ABC Bank";
    private static int totalAccounts = 0;
    
    private String accountHolderName;
    private final int accountNumber;
    private double balance;
    
    // Constructor using 'this' keyword
    public BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;  // final variable
        this.balance = balance;
        totalAccounts++;  // Incrementing the total accounts count
    }
    
    // Static method to get total accounts
    public static void getTotalAccounts() {
        System.out.println("Total accounts in " + bankName + ": " + totalAccounts);
    }
    
    // Display account details
    public void displayAccountDetails() {
        if (this instanceof BankAccount) {  // Using instanceof
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
            System.out.println("----------------------");
        }
    }
    
    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
    
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("John Doe", 1001, 5000);
        BankAccount acc2 = new BankAccount("Jane Smith", 1002, 8000);
        
        acc1.displayAccountDetails();
        acc2.displayAccountDetails();
        
        acc1.deposit(1000);
        acc1.withdraw(2000);
        acc1.displayAccountDetails();
        
        // Display total accounts
        BankAccount.getTotalAccounts();
    }
}
