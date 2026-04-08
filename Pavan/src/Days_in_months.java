import java.util.Scanner;

public class Days_in_months {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Check Days in Month");
            System.out.println("2. Check Leap Year");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Month Number (1-12): ");
                    int month = sc.nextInt();

                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();

                    String monthName = "";
                    int days = 0;

                    // Month name
                    switch (month) {
                        case 1: monthName = "January";
                        break;
                        case 2: monthName = "February";
                        break;
                        case 3: monthName = "March";
                        break;
                        case 4: monthName = "April";
                        break;
                        case 5: monthName = "May"; 
                        break;
                        case 6: monthName = "June";
                        break;
                        case 7: monthName = "July"; 
                        break;
                        case 8: monthName = "August";
                        break;
                        case 9: monthName = "September"; 
                        break;
                        case 10: monthName = "October"; 
                        break;
                        case 11: monthName = "November";
                        break;
                        case 12: monthName = "December"; 
                        break;
                        default:
                            System.out.println("Invalid Month");
                            continue;
                    }

                    // Days calculation
                    switch (month) {

                        case 1: case 3: case 5: case 7:
                        case 8: case 10: case 12:
                            days = 31;
                            break;

                        case 4: case 6: case 9: case 11:
                            days = 30;
                            break;

                        case 2:
                            // Leap year logic
                            if ((year % 400 == 0) || 
                                (year % 4 == 0 && year % 100 != 0)) {
                                days = 29;
                                System.out.println(monthName + " has " + days + " days (Leap Year)");
                            } else {
                                days = 28;
                                System.out.println(monthName + " has " + days + " days");
                            }
                            continue;
                    }

                    System.out.println(monthName + " has " + days + " days");
                    break;

                case 2:
                    System.out.print("Enter Year: ");
                    int y = sc.nextInt();

                    if ((y % 400 == 0) || 
                        (y % 4 == 0 && y % 100 != 0)) {
                        System.out.println("Leap Year");
                    } else {
                        System.out.println("Not a Leap Year");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}