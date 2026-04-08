import java.util.Scanner;

public class Student_grade_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Scanner sc = new Scanner(System.in);

		        int total = 0;

		        for (int i = 1; i <= 5; i++) {
		            System.out.print("Enter marks for subject " + i + ": ");
		            int marks = sc.nextInt();
		            total += marks;
		        }

		        double avg = total / 5.0;

		        System.out.println("Average = " + avg);

		        if (avg >= 90) {
		            System.out.println("Grade A");
		        } else if (avg >= 75) {
		            System.out.println("Grade B");
		        } else if (avg >= 50) {
		            System.out.println("Grade C");
		        } else {
		            System.out.println("Fail");
		        }

		        sc.close();
		    }
	
}
