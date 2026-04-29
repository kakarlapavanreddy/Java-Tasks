import java.util.Scanner;

public class Banking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Array for 3 accounts
        double[] balance = {1000, 2000, 3000};

        while (true) {

            System.out.println("1.Cash 2.Cheque 3.UPI 4.Exit");
            int choice = sc.nextInt();

            System.out.print("Select account (0-2): ");
            int acc = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter cash amount: ");
                balance[acc] += sc.nextDouble();
            } 
            else if (choice == 2) {
                System.out.print("Enter cheque amount: ");
                balance[acc] += sc.nextDouble();
                System.out.println("Cheque processing...");
            } 
            else if (choice == 3) {
                System.out.print("Enter UPI amount: ");
                balance[acc] += sc.nextDouble();
            } 
            else {
                break;
            }

            System.out.println("Updated Balances:");
            for (int i = 0; i < balance.length; i++) {
                System.out.println("Account " + i + ": " + balance[i]);
            }
        }
    }
}