import java.util.ArrayList;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void openAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        for (Account account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber() + " | Balance: " + account.getBalance());
        }
    }
}

class Bank {
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void openAccount(Customer customer, Account account) {
        customer.openAccount(account);
        System.out.println("Account opened for " + customer.getName() + " at " + bankName);
    }
}

public class BankAccountAssociationDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("National Bank");

        Customer customer1 = new Customer("John Doe");
        Customer customer2 = new Customer("Jane Smith");

        Account account1 = new Account("A12345", 5000);
        Account account2 = new Account("B67890", 3000);
        Account account3 = new Account("C11223", 10000);

        bank.openAccount(customer1, account1);
        bank.openAccount(customer2, account2);
        bank.openAccount(customer2, account3);

        customer1.viewBalance();
        customer2.viewBalance();
    }
}
