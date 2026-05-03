package com.nt;

import java.util.*;

public class MovieTickets {

    static Scanner sc = new Scanner(System.in);

    // Store bookings → Phone → Seats
    static HashMap<String, List<String>> bookings = new HashMap<>();

    // Seat map
    static HashMap<String, Boolean> seats = new HashMap<>();

    // Initialize seats
    static void initializeSeats() {

        for (char row = 'A'; row <= 'Z'; row++) {

            int maxSeat;

            if (row <= 'H') {           // Premium
                maxSeat = 25;
            } else if (row <= 'P') {    // Gold
                maxSeat = 20;
            } else {                   // First Class
                maxSeat = 25;
            }

            for (int i = 1; i <= maxSeat; i++) {
                seats.put(row + "" + i, false); // false = available
            }
        }
    }

    public static void main(String[] args) {

        initializeSeats();

        int choice;

        do {
            System.out.println("\n===== MOVIE BOOKING SYSTEM =====");
            System.out.println("1. View Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: viewSeats(); break;
                case 2: bookTicket(); break;
                case 3: cancelTicket(); break;
                case 4: System.out.println("Thank you!"); break;
                default: System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    // -------- VIEW SEATS --------
    static void viewSeats() {

        System.out.println("\n===== SEAT LAYOUT =====");
        System.out.println("Premium (A-H) | Gold (I-P) | First Class (Q-Z)\n");

        for (char row = 'A'; row <= 'Z'; row++) {

            int maxSeat = (row <= 'H') ? 25 : (row <= 'P') ? 20 : 25;

            System.out.print(row + " : ");

            for (int i = 1; i <= maxSeat; i++) {

                String seat = row + "" + i;

                if (seats.get(seat)) {
                    System.out.print("[X] "); // booked
                } else {
                    System.out.print("[O] "); // available
                }
            }
            System.out.println();
        }
    }

    // -------- BOOK --------
    static void bookTicket() {

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Seat (e.g., A10): ");
        String seat = sc.nextLine().toUpperCase();

        if (!seats.containsKey(seat)) {
            System.out.println("Invalid seat!");
            return;
        }

        if (seats.get(seat)) {
            System.out.println("Seat already booked!");
            return;
        }

        seats.put(seat, true);

        bookings.putIfAbsent(phone, new ArrayList<>());
        bookings.get(phone).add(seat);

        int price = getPrice(seat);

        System.out.println("Booking successful!");
        System.out.println("Seat: " + seat);
        System.out.println("Category: " + getCategory(seat));
        System.out.println("Price: ₹" + price);
    }

    // -------- CANCEL --------
    static void cancelTicket() {

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        if (!bookings.containsKey(phone)) {
            System.out.println("No booking found!");
            return;
        }

        System.out.println("Your Seats: " + bookings.get(phone));

        System.out.print("Enter Seat to Cancel: ");
        String seat = sc.nextLine().toUpperCase();

        if (bookings.get(phone).contains(seat)) {

            seats.put(seat, false);
            bookings.get(phone).remove(seat);

            System.out.println("Ticket Cancelled!");
        } else {
            System.out.println("Invalid seat!");
        }
    }

    // -------- CATEGORY --------
    static String getCategory(String seat) {

        char row = seat.charAt(0);

        if (row <= 'H') return "Premium";
        else if (row <= 'P') return "Gold";
        else return "First Class";
    }

    // -------- PRICE --------
    static int getPrice(String seat) {

        char row = seat.charAt(0);

        if (row <= 'H') return 300;
        else if (row <= 'P') return 200;
        else return 150;
    }
}
