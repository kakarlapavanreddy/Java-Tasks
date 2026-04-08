import java.util.Scanner;

public class Loan_Eligibility {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== LOAN MENU =====");
            System.out.println("1. Check Loan Eligibility");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();

                System.out.print("Enter CIBIL Score: ");
                int cibil = sc.nextInt();

                System.out.print("Employment Status (1-Employed, 0-Unemployed): ");
                int status = sc.nextInt();

                System.out.println("\n----- RESULT -----");

                // Step-by-step explanation
                if (age >= 21 && age <= 60) {

                    System.out.println("Age is eligible");

                    if (salary >= 25000) {
                        System.out.println("Salary is sufficient");

                        if (cibil >= 700) {
                            System.out.println("CIBIL score is good");

                            if (status == 1) {
                                System.out.println("Employment status is valid");
                                System.out.println("Loan Approved");
                            } else {
                                System.out.println("Not employed → Loan Rejected");
                            }

                        } else {
                            System.out.println("Low CIBIL score → Loan Rejected");
                        }

                    } else {
                        System.out.println("Salary too low → Loan Rejected");
                    }

                } else {
                    System.out.println("Age not eligible (must be 21–60)");
                }

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