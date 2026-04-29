import java.util.Scanner;

public class Stocks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Array to store stock for 3 products
        int[] stock = {10, 20, 30};

        while (true) {

            System.out.println("1.Add 2.Remove 3.Reset 4.Exit");
            int choice = sc.nextInt();

            System.out.print("Select product index (0-2): ");
            int index = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter quantity: ");
                stock[index] += sc.nextInt();
            } 
            else if (choice == 2) {
                System.out.print("Enter quantity: ");
                stock[index] -= sc.nextInt();
            } 
            else if (choice == 3) {
                stock[index] = 0;
            } 
            else {
                break;
            }

            System.out.println("Updated Stock:");
            for (int i = 0; i < stock.length; i++) {
                System.out.println("Product " + i + ": " + stock[i]);
            }
        }
    }
}