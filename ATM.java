import java.util.Scanner;

public class ATM {
    float Balance;
    int PIN = 3456;
    public static void main(String[] args) {
      ATM obj = new ATM();
      obj.checkPIN();
    }

    public void checkPIN(){
        System.out.println("ENTER YOUR PIN: ");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();
        
        if (enteredpin == PIN) {
            menu();
        } 
        else {
            System.out.println("Wrong Pin");
            checkPIN();
        }
    }

    public void checkbalance(){
        System.out.println("Balance: " + Balance);
        menu();
    }

    public void withdrawn() {
        System.out.println("Enter amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        float money = sc.nextFloat();

        if (Balance < money) {
            System.out.println("Insufficient balance");
        } else {
            Balance = Balance - money;
            System.out.println("Money withdrawn successfully");
            System.out.println("new money: "+ Balance);
        }
        menu();
    }

    public void deposit() {
        System.out.println("Enter the deposit amount: ");
        Scanner sc = new Scanner(System.in);
        float money = sc.nextFloat();
        Balance = Balance + money;
        System.out.println("Deposit successful");
        System.out.println("new money: "+ Balance);
        menu();
    }

    public void menu() {
        System.out.println("1: Check Balance");
        System.out.println("2: Withdraw Money");
        System.out.println("3: Deposit Money");
        System.out.println("4: Exit");

        Scanner sc = new Scanner(System.in);
        int entered = sc.nextInt();
        
        if (entered == 1) {
            checkbalance();
        } 
        else if (entered == 2) {
            withdrawn();
        } 
        else if (entered == 3) {
            deposit();
        } 
        else if (entered == 4) {
            checkPIN(); 
        } else {
            System.out.println("Invalid option. Please enter a valid choice.");
            menu(); 
        }
    }
}
