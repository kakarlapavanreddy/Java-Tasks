import java.util.Scanner;

public class Emp_sal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        Scanner sc = new Scanner(System.in);

		        // Input employee details
		        System.out.print("Enter Employee Name: ");
		        String name = sc.nextLine();

		        System.out.print("Enter Designation: ");
		        String des = sc.nextLine();

		        System.out.print("Enter Experience (years): ");
		        int exp = sc.nextInt();

		        System.out.print("Enter Salary: ");
		        double salary = sc.nextDouble();

		        double bonus = 0;

		        // Bonus based on experience
		        if (exp >= 5) {
		            bonus = salary * 0.20;
		        } else if (exp >= 2) {
		            bonus = salary * 0.10;
		        } else {
		            bonus = salary * 0.05;
		        }

		        double total = salary + bonus;

		        // Output
		        System.out.println("Name: " + name);
		        System.out.println("Designation: " + des);
		        System.out.println("Bonus: " + bonus);
		        System.out.println("Total Salary: " + total);

		        sc.close();
		    }
		}