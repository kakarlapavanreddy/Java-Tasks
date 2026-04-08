import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int balance = 100000;
        int correctPin = 1234;
        int enteredPin;
        int attempts = 0;

        // LOGIN PROCESS
        System.out.println("Insert your card...");
        
        while (true) {
            System.out.print("Enter PIN: ");
            enteredPin = sc.nextInt();

            if (enteredPin == correctPin) {
                System.out.println("PIN Verified Successfully");
                break;
            } else {
                attempts++;
                System.out.println("Wrong PIN");

                if (attempts == 3) {
                    System.out.println("Card Blocked! Too many attempts.");
                    return; 
                    // exit program
                }
            }
        }

        // ATM MENU
        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose Option: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: " + balance);
                    break;

                case 2:
                    System.out.print("Enter Amount to Deposit: ");
                    int deposit = sc.nextInt();

                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Amount Deposited");
                        System.out.println("Updated Balance: " + balance);
                    } else {
                        System.out.println("Invalid Amount");
                    }
                    break;

                case 3:
                    System.out.print("Enter Amount to Withdraw: ");
                    int withdraw = sc.nextInt();

                    if (withdraw <= 0) {
                        System.out.println("Invalid Amount");
                    } 
                    else if (withdraw > balance) {
                        System.out.println("Insufficient Balance");
                    } 
                    else {
                        balance -= withdraw;
                        System.out.println("Withdrawal Successful");
                        System.out.println("Remaining Balance: " + balance);
                    }
                    break;

                case 4:
                    System.out.println("Please collect your card. Thank you!");
                    break;

                default:
                    System.out.println("Invalid Option");
            }

        } while (choice != 4);

        sc.close();
    }
}