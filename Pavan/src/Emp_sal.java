import java.util.Scanner;

public class Emp_sal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Scanner sc = new Scanner(System.in);

		        double salary;
		        double total = 0;

		        // Loop to read 10 employees
		        for (int i = 1; i <= 10; i++) {

		            System.out.print("Enter salary of employee " + i + ": ");
		            salary = sc.nextDouble();

		            total += salary;
		        }

		        double average = total / 10;

		        System.out.println("\n===== RESULT =====");
		        System.out.println("Total Salary = " + total);
		        System.out.println("Average Salary = " + average);

		        sc.close();
		    }

}
