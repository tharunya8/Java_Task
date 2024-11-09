
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create ATM with user-defined PIN and starting balance
        Scanner scanner = new Scanner(System.in);

       System.out.println("Set your pin:");
        int pin= scanner.nextInt();

        System.out.println("Set your balance:");
        double balance = scanner.nextDouble();

         //Initialize ATM system with user PIN and balance
        AtmSystem atm = new AtmSystem(pin, balance);
        atm.run();
    }
}
