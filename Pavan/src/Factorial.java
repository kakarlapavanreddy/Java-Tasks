import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);  
        // Create Scanner object
        
        System.out.print("Enter a number: ");  
        // Ask user input
        int num = sc.nextInt();              
        // Read number
        
        int fact = 1;                          
        // Store factorial result
        
        for(int i = 1; i <= num; i++) {        
        	// Loop from 1 to num
            fact = fact * i;                   
            // Multiply and update
        }
        
        System.out.println("Factorial is: " + fact); // Print result
    }
}