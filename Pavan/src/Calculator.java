import java.util.Scanner;

public class Calculator {

    // Method for addition
    static int add(int a, int b) {
        return a + b; // returns sum
    }

    // Method for subtraction
    static int sub(int a, int b) {
        return a - b; // returns difference
    }

    // Method for multiplication
    static int mul(int a, int b) {
        return a * b; // returns product
    }

    // Method for division
    static int div(int a, int b) {
        return a / b; // returns division result
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Display menu
        System.out.println("1.Add 2.Sub 3.Mul 4.Div");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        // Input numbers
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Switch to call methods
        switch (choice) {
            case 1:
                System.out.println("Result: " + add(a, b));
                break;
            case 2:
                System.out.println("Result: " + sub(a, b));
                break;
            case 3:
                System.out.println("Result: " + mul(a, b));
                break;
            case 4:
                System.out.println("Result: " + div(a, b));
                break;
            default:
                System.out.println("Invalid choice");
        }

        sc.close(); // close scanner
    }
}