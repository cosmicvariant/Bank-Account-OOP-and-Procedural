import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner myScanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bank Account Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Perform Transaction");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = myScanner.nextInt();
            myScanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Please enter Account Number: ");
                    String accountNumber = myScanner.nextLine();
                    System.out.print("Please enter Account Holder Name: ");
                    String accountHolderName = myScanner.nextLine();
                    System.out.print("Please enter Initial Balance: ");
                    double initialBalance = myScanner.nextDouble();
                    bank.createAccount(accountNumber, accountHolderName, initialBalance);
                    break;

                case 2:
                    System.out.print("Please enter Account Number: ");
                    accountNumber = myScanner.nextLine();
                    System.out.print("Enter Transaction Type (Deposit/Withdraw): ");
                    String transactionType = myScanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = myScanner.nextDouble();
                    bank.performTransaction(accountNumber, transactionType, amount);
                    break;

                case 3:
                    System.out.print("Please enter Account Number: ");
                    accountNumber = myScanner.nextLine();
                    bank.displayBalance(accountNumber);
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    myScanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}