import java.util.Scanner;

public class Food_menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        Scanner sc = new Scanner(System.in);
		        int category;

		        do {
		            System.out.println("\n===== FOOD MENU =====");
		            System.out.println("1. Breakfast");
		            System.out.println("2. Lunch");
		            System.out.println("3. Dinner");
		            System.out.println("4. Exit");
		            System.out.print("Select Category: ");

		            category = sc.nextInt();

		            switch (category) {

		                case 1:
		                    System.out.println("\n--- Breakfast Menu ---");
		                    System.out.println("1. Idli");
		                    System.out.println("2. Dosa");
		                    System.out.println("3. Poori");
		                    System.out.print("Choose Item: ");
		                    int b = sc.nextInt();

		                    switch (b) {

		                        case 1:
		                            System.out.println("You selected Idli");
		                            break;

		                        case 2:
		                            // Dosa Varieties
		                            System.out.println("\n--- Dosa Varieties ---");
		                            System.out.println("1. Plain Dosa");
		                            System.out.println("2. Onion Dosa");
		                            System.out.println("3. Ghee Dosa");
		                            System.out.println("4. Back");
		                            System.out.print("Choose Dosa Type: ");
		                            int dosa = sc.nextInt();

		                            switch (dosa) {
		                                case 1:
		                                    System.out.println("You selected Plain Dosa");
		                                    break;
		                                case 2:
		                                    System.out.println("You selected Onion Dosa");
		                                    break;
		                                case 3:
		                                    System.out.println("You selected Ghee Dosa");
		                                    break;
		                                case 4:
		                                    System.out.println("Going Back...");
		                                    break;
		                                default:
		                                    System.out.println("Invalid Choice");
		                            }
		                            break;

		                        default:
		                            System.out.println("Invalid Choice");
		                    }
		                    break;

		                case 2:
		                    System.out.println("\n--- Lunch Menu ---");
		                    System.out.println("1. Meals");
		                    System.out.println("2. Biryani");
		                    System.out.print("Choose Item: ");
		                    int l = sc.nextInt();

		                    switch (l) {
		                        case 1:
		                            System.out.println("You selected Meals");
		                            break;
		                        case 2:
		                            System.out.println("You selected Biryani");
		                            break;
		                        default:
		                            System.out.println("Invalid Choice");
		                    }
		                    break;

		                case 3:
		                    System.out.println("\n--- Dinner Menu ---");
		                    System.out.println("1. Chapati");
		                    System.out.println("2. Fried Rice");
		                    System.out.print("Choose Item: ");
		                    int d = sc.nextInt();

		                    switch (d) {
		                        case 1:
		                            System.out.println("You selected Chapati");
		                            break;
		                        case 2:
		                            System.out.println("You selected Fried Rice");
		                            break;
		                        default:
		                            System.out.println("Invalid Choice");
		                    }
		                    break;

		                case 4:
		                    System.out.println("Exiting... Thank you!");
		                    break;

		                default:
		                    System.out.println("Invalid Category");
		            }

		        } while (category != 4);

		        sc.close();
		    }
		}