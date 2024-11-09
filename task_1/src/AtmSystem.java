import java.util.Scanner;

public class AtmSystem {
    private int pin;
    private double balance;
    private boolean authenticated;


    // Constructor to initialize the PIN and balance dynamically
    public AtmSystem(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
        this.authenticated = false;
    }

    // Method to run the ATM system (authentication + menu)
    public void run() {
        if (authenticateUser()) {
            displayMenu();
        } else {
            System.out.println("Authentication failed. Exiting system.");
        }
    }

    // Method to authenticate the user
    private boolean authenticateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == pin) {
            authenticated = true;
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Invalid PIN.");
        }
        return authenticated;
    }

    // Display the ATM menu and handle user input
    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Menu loop
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Exiting. Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    // Method to check the balance
    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    // Method to deposit money
    private void depositMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");

        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f%n", amount);
            checkBalance();
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    // Method to withdraw money
    private void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");

        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew $%.2f%n", amount);
            checkBalance();
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
}
