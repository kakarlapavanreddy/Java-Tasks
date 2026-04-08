import java.util.Scanner;

public class Login_System {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        Scanner sc = new Scanner(System.in); // Input object

		        // Step 1: Register user
		        System.out.print("Set Username: ");
		        String username = sc.nextLine();

		        System.out.print("Set Password: ");
		        String password = sc.nextLine();

		        int attempts = 3; // Max login attempts
		        boolean isLoggedIn = false; // Login status

		        // Step 2: Login loop
		        while (attempts > 0) {

		            System.out.print("\nEnter Username: ");
		            String inputUser = sc.nextLine();

		            System.out.print("Enter Password: ");
		            String inputPass = sc.nextLine();

		            // Check credentials
		            if (username.equals(inputUser) && password.equals(inputPass)) {
		                System.out.println("Login Successful");
		                isLoggedIn = true;
		                break;
		            } else {
		                attempts--;
		                System.out.println("Invalid Credentials");
		                System.out.println("Attempts left: " + attempts);
		            }
		        }

		        // Step 3: Reset password if login failed
		        if (!isLoggedIn) {
		            System.out.println("\nToo many failed attempts!");

		            System.out.print("Do you want to reset password? (yes/no): ");
		            String choice = sc.nextLine();

		            if (choice.equalsIgnoreCase("yes")) {
		                System.out.print("Enter new password: ");
		                password = sc.nextLine();

		                System.out.println("Password reset successful!");

		                // Try login again
		                System.out.print("\nLogin again\n");
		                System.out.print("Enter Username: ");
		                String newUser = sc.nextLine();

		                System.out.print("Enter Password: ");
		                String newPass = sc.nextLine();

		                if (username.equals(newUser) && password.equals(newPass)) {
		                    System.out.println("Login Successful after reset");
		                } else {
		                    System.out.println("Still wrong credentials");
		                }
		            } else {
		                System.out.println("Exiting program...");
		            }
		        }

		        sc.close(); // Close scanner
		    }
		}