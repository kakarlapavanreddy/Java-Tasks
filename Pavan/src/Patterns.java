
public class Patterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		for (int i = 1; i <= 5; i++) {
//		    for (int j = 1; j <= i; j++) {
//		        System.out.print("* ");
//		    }
//		    System.out.println();
//		}
		
		
		//Reverse Triangle
		
//		for (int i = 5; i >= 1; i--) {
//		    for (int j = 1; j <= i; j++) {
//		        System.out.print("* ");
//		    }
//		    System.out.println();
//		}
		
		//Number Triangle
		
//		for (int i = 1; i <= 5; i++) {
//		    for (int j = 1; j <= i; j++) {
//		        System.out.print(j + " ");
//		    }
//		    System.out.println();
//		}
//		
//		System.out.println("\n");
//		
//		
//		for (int i = 1; i <= 5; i++) {
//		    for (int j = 1; j <= i; j++) {
//		        System.out.print(i + " ");
//		    }
//		    System.out.println();
//		}
		
		//Pyramid Pattern
		
		for (int i = 1; i <= 5; i++) {

		    // spaces
		    for (int j = 1; j <= 5 - i; j++) {
		        System.out.print(" ");
		    }

		    // stars
		    for (int k = 1; k <= (2 * i - 1); k++) {
		        System.out.print("*");
		    }

		    System.out.println();
		}

	}

}
