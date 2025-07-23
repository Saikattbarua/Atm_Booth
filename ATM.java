import java.util.Scanner;

public class ATM {
    private float balance = 0;
    private final int PIN = 3456;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }

    public void start() {
        System.out.println("Welcome to Smart ATM!");
        while (true) {
            System.out.print("\nPlease enter your 4-digit PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == PIN) {
                System.out.println("PIN Verified Successfully.\n");
                menu();
                break;
            } else {
                System.out.println("Incorrect PIN. Try again.");
            }
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Select an option (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    System.out.println("Thank you for using Smart ATM. Goodbye!");
                    return; // exit menu
                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
            }
        }
    }

    public void checkBalance() {
        System.out.printf("Your current balance is: ৳%.2f\n", balance);
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ৳");
        float amount = scanner.nextFloat();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf("Withdrawal successful. New balance: ৳%.2f\n", balance);
        }
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ৳");
        float amount = scanner.nextFloat();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            balance += amount;
            System.out.printf("Deposit successful. New balance: ৳%.2f\n", balance);
        }
    }
}
