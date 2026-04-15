import java.util.Scanner;

public class HouseSystem {

    // Method to calculate rent
    double calculateRent(double monthlyRent, int months) {
        return monthlyRent * months;
    }

    // Method to calculate lease
    double calculateLease(double leaseAmount) {
        return leaseAmount;
    }

    // Method to calculate security deposit (10%)
    double calculateDeposit(double amount) {
        return amount * 0.10;
    }

    // Method to display details
    void display(String name, String type, double amount, double deposit) {
        System.out.println("\nOwner Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Total Amount: " + amount);
        System.out.println("Security Deposit: " + deposit);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HouseSystem h = new HouseSystem();

        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();

        String[] owner = new String[n];
        String[] type = new String[n];
        double[] amount = new double[n];
        double[] deposit = new double[n];

        // 🔹 INPUT DATA
        for(int i = 0; i < n; i++) {

            System.out.println("\n--- House " + (i+1) + " ---");

            System.out.print("Enter owner name: ");
            owner[i] = sc.next();

            System.out.print("Enter type (rent/lease): ");
            type[i] = sc.next();

            if(type[i].equalsIgnoreCase("rent")) {

                System.out.print("Enter monthly rent: ");
                double rent = sc.nextDouble();

                System.out.print("Enter months: ");
                int months = sc.nextInt();

                amount[i] = h.calculateRent(rent, months);

            } else if(type[i].equalsIgnoreCase("lease")) {

                System.out.print("Enter lease amount: ");
                double lease = sc.nextDouble();

                amount[i] = h.calculateLease(lease);

            } else {
                System.out.println("Invalid type!");
                i--; // retry
                continue;
            }

            // calculate deposit
            deposit[i] = h.calculateDeposit(amount[i]);
        }

        // 🔹 DISPLAY ALL
        System.out.println("\n===== ALL HOUSE DETAILS =====");
        for(int i = 0; i < n; i++) {
            h.display(owner[i], type[i], amount[i], deposit[i]);
        }

        // 🔹 SEARCH BY OWNER NAME
        System.out.print("\nEnter owner name to search: ");
        String search = sc.next();

        boolean found = false;

        for(int i = 0; i < n; i++) {

            if(owner[i].equalsIgnoreCase(search)) {

                System.out.println("\n===== SEARCH RESULT =====");
                h.display(owner[i], type[i], amount[i], deposit[i]);

                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Owner not found!");
        }

        sc.close();
    }
}