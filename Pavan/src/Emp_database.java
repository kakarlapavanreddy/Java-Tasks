import java.util.Scanner;

public class Emp_database {

    public static void main(String[] args) {
    	        Scanner sc = new Scanner(System.in);
    	        int choice;

    	        do {
    	            System.out.println("\n===== EMPLOYEE MENU =====");
    	            System.out.println("1. Add Employee");
    	            System.out.println("2. Exit");
    	            System.out.print("Enter your choice: ");
    	            
    	            choice = sc.nextInt();
    	            sc.nextLine(); // clear buffer

    	            if (choice == 1) {

    	                System.out.print("Enter Employee ID: ");
    	                int id = sc.nextInt();
    	                sc.nextLine();

    	                System.out.print("Enter Name: ");
    	                String name = sc.nextLine();

    	                System.out.print("Enter Designation: ");
    	                String designation = sc.nextLine();

    	                System.out.print("Enter Salary: ");
    	                double salary = sc.nextDouble();

    	                // HRA
    	                double hra = salary * 0.20;

    	                // PF
    	                double pf = salary * 0.12;

    	                // TAX using else-if
    	                double tax = 0;

    	                if (salary <= 25000) {
    	                    tax = salary * 0.05;
    	                } 
    	                else if (salary <= 50000) {
    	                    tax = salary * 0.10;
    	                } 
    	                else {
    	                    tax = salary * 0.20;
    	                }

    	                // Gross & Net
    	                double gross = salary + hra;
    	                double net = gross - (tax + pf);

    	                // Output
    	                System.out.println("\n----- EMPLOYEE DETAILS -----");
    	                System.out.println("ID: " + id);
    	                System.out.println("Name: " + name);
    	                System.out.println("Designation: " + designation);
    	                System.out.println("Salary: " + salary);
    	                System.out.println("HRA: " + hra);
    	                System.out.println("PF: " + pf);
    	                System.out.println("Tax: " + tax);
    	                System.out.println("Gross Salary: " + gross);
    	                System.out.println("Net Salary: " + net);
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