import java.util.Scanner;

public class Current_bill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Scanner sc = new Scanner(System.in);
		        int choice;

		        do {
		            System.out.println("\n===== CURRENT BILL MENU =====");
		            System.out.println("1. Generate Bill");
		            System.out.println("2. Exit");
		            System.out.print("Enter your choice: ");
		            
		            choice = sc.nextInt();

		            switch (choice) {

		                case 1:
		                    sc.nextLine(); // clear buffer

		                    System.out.print("Enter Bill ID: ");
		                    int billId = sc.nextInt();
		                    sc.nextLine();

		                    System.out.print("Enter Customer Name: ");
		                    String name = sc.nextLine();

		                    System.out.print("Enter Old Units: ");
		                    int oldUnits = sc.nextInt();

		                    System.out.print("Enter New Units: ");
		                    int newUnits = sc.nextInt();

		                    int usedUnits = newUnits - oldUnits;

		                    if (usedUnits < 0) {
		                        System.out.println("Error: New units must be greater than old units!");
		                        break;
		                    }

		                    // 🔥 FIXED PRICE
		                    double pricePerUnit = 5;

		                    double totalBill = usedUnits * pricePerUnit;

		                    // Output
		                    System.out.println("\n----- BILL DETAILS -----");
		                    System.out.println("Bill ID: " + billId);
		                    System.out.println("Customer Name: " + name);
		                    System.out.println("Old Units: " + oldUnits);
		                    System.out.println("New Units: " + newUnits);
		                    System.out.println("Units Used: " + usedUnits);
		                    System.out.println("Price per Unit: ₹" + pricePerUnit);
		                    System.out.println("Total Bill Amount: ₹" + totalBill);
		                    break;

		                case 2:
		                    System.out.println("Exiting...");
		                    break;

		                default:
		                    System.out.println("Invalid choice!");
		            }

		        } while (choice != 2);

		        sc.close();
		    }

}
