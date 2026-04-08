import java.util.Scanner;

public class Palindrome{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  
        // Input object

        System.out.print("Enter a number: ");
        int num = sc.nextInt();                
        // Original number

        int original = num;                    
        // Store original value
        int reverse = 0;                       
        // To store reversed number

        while(num > 0) {                       
        	// Loop until number becomes 0
            int digit = num % 10;             
            // Get last digit
            reverse = reverse * 10 + digit;    
            // Build reverse number
            num = num / 10;                   
            // Remove last digit
        }

        if(original == reverse) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}