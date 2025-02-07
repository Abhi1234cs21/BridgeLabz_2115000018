class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountDetails() {
        return "Account Number: " + accountNumber + ", Balance: $" + balance;
    }
}

class SavingsAccount {
    BankAccount bankAccount;
    double interestRate;

    SavingsAccount(BankAccount bankAccount, double interestRate) {
        this.bankAccount = bankAccount;
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Savings Account, Interest Rate: " + interestRate + "%");
    }

    public String getAccountDetails() {
        return bankAccount.getAccountDetails() + ", Interest Rate: " + interestRate + "%";
    }
}

class CheckingAccount {
    BankAccount bankAccount;
    double withdrawalLimit;

    CheckingAccount(BankAccount bankAccount, double withdrawalLimit) {
        this.bankAccount = bankAccount;
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Checking Account, Withdrawal Limit: $" + withdrawalLimit);
    }

    public String getAccountDetails() {
        return bankAccount.getAccountDetails() + ", Withdrawal Limit: $" + withdrawalLimit;
    }
}

class FixedDepositAccount {
    BankAccount bankAccount;
    int maturityPeriod; // in months

    FixedDepositAccount(BankAccount bankAccount, int maturityPeriod) {
        this.bankAccount = bankAccount;
        this.maturityPeriod = maturityPeriod;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account, Maturity Period: " + maturityPeriod + " months");
    }

    public String getAccountDetails() {
        return bankAccount.getAccountDetails() + ", Maturity Period: " + maturityPeriod + " months";
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        BankAccount basicAccount = new BankAccount("12345", 5000);
        SavingsAccount savingsAccount = new SavingsAccount(basicAccount, 5.0);
        CheckingAccount checkingAccount = new CheckingAccount(basicAccount, 1000);
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount(basicAccount, 12);

        savingsAccount.displayAccountType();
        System.out.println(savingsAccount.getAccountDetails());

        checkingAccount.displayAccountType();
        System.out.println(checkingAccount.getAccountDetails());

        fixedDepositAccount.displayAccountType();
        System.out.println(fixedDepositAccount.getAccountDetails());
    }
}
