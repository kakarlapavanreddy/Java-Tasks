import java.util.Scanner;

public class Electricity_bills {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        Scanner sc = new Scanner(System.in);

		        int totalBill = 0;

		        // Loop for 6 months
		        for (int i = 1; i <= 6; i++) {

		            System.out.println("\n----- Month " + i + " -----");

		            System.out.print("Enter Units Consumed: ");
		            int units = sc.nextInt();

		            double bill = 0;

		            // Slab calculation using if-else
		            if (units <= 100) {
		                bill = units * 3;
		            } 
		            else if (units <= 200) {
		                bill = (100 * 3) + ((units - 100) * 5);
		            } 
		            else if (units <= 300) {
		                bill = (100 * 3) + (100 * 5) + ((units - 200) * 7);
		            } 
		            else {
		                bill = (100 * 3) + (100 * 5) + (100 * 7) + ((units - 300) * 10);
		            }

		            System.out.println("Bill for Month " + i + " = ₹" + bill);

		            totalBill += bill;
		        }

		        System.out.println("\n===== TOTAL BILL FOR 6 MONTHS =====");
		        System.out.println("Total Amount = ₹" + totalBill);

		        sc.close();
		    }

}
