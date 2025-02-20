import java.util.*;

public class BankingSystem {

    public static void main(String[] args) {
        // Initialize the bank system with accounts and balances
        Map<String, Double> accounts = new HashMap<>();
        accounts.put("1001", 5000.0); // Account 1001 has a balance of 5000
        accounts.put("1002", 3000.0); // Account 1002 has a balance of 3000
        accounts.put("1003", 10000.0); // Account 1003 has a balance of 10000
        accounts.put("1004", 2500.0); // Account 1004 has a balance of 2500
        
        // Initialize a Queue to process withdrawal requests (FIFO)
        Queue<String> withdrawalQueue = new LinkedList<>();
        
        // Process some withdrawal requests
        withdrawalQueue.add("1001"); // Withdrawal request from account 1001
        withdrawalQueue.add("1004"); // Withdrawal request from account 1004
        withdrawalQueue.add("1002"); // Withdrawal request from account 1002
        
        // Process the withdrawal requests from the queue
        processWithdrawals(accounts, withdrawalQueue, 500.0); // Withdraw 500 from each account
        
        // Display the sorted accounts by balance (TreeMap)
        System.out.println("\nSorted Accounts by Balance:");
        displaySortedAccountsByBalance(accounts);
    }

    // Method to process withdrawal requests from the queue
    public static void processWithdrawals(Map<String, Double> accounts, Queue<String> withdrawalQueue, double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            if (accounts.containsKey(accountNumber)) {
                double balance = accounts.get(accountNumber);
                if (balance >= amount) {
                    // Withdraw the amount
                    accounts.put(accountNumber, balance - amount);
                    System.out.println("Withdrawal of $" + amount + " processed for account " + accountNumber + ". New balance: $" + (balance - amount));
                } else {
                    // Insufficient funds
                    System.out.println("Account " + accountNumber + " has insufficient funds for a withdrawal of $" + amount);
                }
            } else {
                System.out.println("Account " + accountNumber + " does not exist.");
            }
        }
    }

    // Method to display accounts sorted by balance using TreeMap
    public static void displaySortedAccountsByBalance(Map<String, Double> accounts) {
        // Convert the HashMap to a TreeMap to sort by balance
        Map<String, Double> sortedAccounts = new TreeMap<>(new BalanceComparator(accounts));
        sortedAccounts.putAll(accounts);
        
        // Print sorted accounts by balance
        for (Map.Entry<String, Double> entry : sortedAccounts.entrySet()) {
            System.out.println("Account " + entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Custom comparator for sorting by balance in ascending order
    static class BalanceComparator implements Comparator<String> {
        private final Map<String, Double> accounts;

        public BalanceComparator(Map<String, Double> accounts) {
            this.accounts = accounts;
        }

        @Override
        public int compare(String account1, String account2) {
            return Double.compare(accounts.get(account1), accounts.get(account2));
        }
    }
}
