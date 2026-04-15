import java.util.Scanner;

public class LoginSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String correctUser = "admin";
        String correctPass = "Admin@123";

        // Take input
        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        // Validate username & password
        if (user.equals(correctUser) && pass.equals(correctPass)) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Invalid Login");
        }

        // Password Strength Check
        boolean upper = false, lower = false, digit = false, special = false;

        for (int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);

            if (Character.isUpperCase(ch)) upper = true;
            else if (Character.isLowerCase(ch)) lower = true;
            else if (Character.isDigit(ch)) digit = true;
            else special = true;
        }

        if (upper && lower && digit && special) {
            System.out.println("Strong Password");
        } else {
            System.out.println("Weak Password");
        }

        sc.close();
    }
}