import java.util.*;
import java.io.*;

// ----------- TICKET CLASS -----------
class Ticket {
    String userName;
    int row;
    int col;

    public Ticket(String userName, int row, int col) {
        this.userName = userName;
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return userName + " booked seat [" + row + "," + col + "]";
    }
}

// ----------- MAIN CLASS -----------
public class MovieBooking {

    static boolean[][] seats = new boolean[5][5]; // false = available
    static Map<String, List<Ticket>> bookings = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MOVIE TICKET BOOKING =====");
            System.out.println("1. Show Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. View My Bookings");
            System.out.println("4. Save Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showSeats();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    viewBookings();
                    break;

                case 4:
                    saveToFile();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ----------- SHOW SEATS -----------
    public static void showSeats() {
        System.out.println("\nO = Available | X = Booked\n");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }

    // ----------- BOOK TICKET -----------
    public static void bookTicket() {
        try {
            sc.nextLine(); // consume newline

            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            showSeats();

            System.out.print("Enter row (0-4): ");
            int r = sc.nextInt();

            System.out.print("Enter column (0-4): ");
            int c = sc.nextInt();

            if (r < 0 || r >= 5 || c < 0 || c >= 5) {
                throw new Exception("Invalid seat position!");
            }

            if (seats[r][c]) {
                throw new Exception("Seat already booked!");
            }

            seats[r][c] = true;

            Ticket ticket = new Ticket(name, r, c);

            bookings.putIfAbsent(name, new ArrayList<>());
            bookings.get(name).add(ticket);

            System.out.println("✅ Ticket booked successfully!");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // ----------- VIEW BOOKINGS -----------
    public static void viewBookings() {
        sc.nextLine();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        if (!bookings.containsKey(name)) {
            System.out.println("No bookings found!");
            return;
        }

        System.out.println("\n--- Your Bookings ---");
        for (Ticket t : bookings.get(name)) {
            System.out.println(t);
        }
    }

    // ----------- SAVE TO FILE -----------
    public static void saveToFile() {
        try (FileWriter fw = new FileWriter("tickets.txt")) {
            for (List<Ticket> list : bookings.values()) {
                for (Ticket t : list) {
                    fw.write(t.toString() + "\n");
                }
            }
            System.out.println("✅ Bookings saved to file");
        } catch (IOException e) {
            System.out.println("❌ File error: " + e.getMessage());
        }
    }
}