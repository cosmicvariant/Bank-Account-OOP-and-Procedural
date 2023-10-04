import java.util.HashMap;
import java.util.Map;




   public class  BankAccount {
        private String accountNumber;
        private String accountHolderName;
        private double balance;

        public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = initialBalance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited $" + amount + " into account " + accountNumber);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn $" + amount + " from account " + accountNumber);
            } else {
                System.out.println("Invalid withdrawal or insufficient balance.");
            }
        }

        public double getBalance() {
            return balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountHolderName() {
            return accountHolderName;
        }
    }

    class Bank {
        private Map<String, BankAccount> accounts;

        public Bank() {
            accounts = new HashMap<>();
        }

        public void createAccount(String accountNumber, String accountHolderName, double initialBalance) {
            if (!accounts.containsKey(accountNumber)) {
                BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);
                accounts.put(accountNumber, account);
                System.out.println("Account created successfully.");
            } else {
                System.out.println("Account already exists with the same account number.");
            }
        }

        public void performTransaction(String accountNumber, String transactionType, double amount) {
            BankAccount account = accounts.get(accountNumber);
            if (account != null) {
                if (transactionType.equalsIgnoreCase("deposit")) {
                    account.deposit(amount);
                } else if (transactionType.equalsIgnoreCase("withdraw")) {
                    account.withdraw(amount);
                } else {
                    System.out.println("Invalid transaction type.");
                }
            } else {
                System.out.println("Account not found.");
            }
        }

        public void displayBalance(String accountNumber) {
            BankAccount account = accounts.get(accountNumber);
            if (account != null) {
                System.out.println("Account Holder: " + account.getAccountHolderName());
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Balance: $" + account.getBalance());
            } else {
                System.out.println("Account not found.");
            }
        }
    }





