import java.util.Scanner;

public class Student_mgmt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Branch: ");
                String branch = sc.nextLine();

                System.out.print("Enter Year: ");
                int year = sc.nextInt();

                System.out.print("Enter Attendance (%): ");
                double attendance = sc.nextDouble();

                String scholarshipStatus;

                // Conditional logic (if-else)
                if (attendance >= 85) {
                    scholarshipStatus = "Eligible for Scholarship";
                } 
                else if (attendance >= 70) {
                    scholarshipStatus = "Conditionally Eligible";
                } 
                else {
                    scholarshipStatus = "Not Eligible";
                }

                // Output
                System.out.println("\n----- STUDENT DETAILS -----");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Branch: " + branch);
                System.out.println("Year: " + year);
                System.out.println("Attendance: " + attendance + "%");
                System.out.println("Scholarship Status: " + scholarshipStatus);
            }

            else if (choice == 2) {
                System.out.println("Exiting...");
            }

            else {
                System.out.println("Invalid choice!");
            }

        } while (choice != 2);

        sc.close();
    }
}