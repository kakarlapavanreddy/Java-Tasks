package com.nt;

import java.util.*;
import java.time.*;

// -------- BOOK CLASS --------
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;
    String issuedTo;
    LocalDate issueDate;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void display() {
        System.out.println("ID: " + id +
                " | Title: " + title +
                " | Author: " + author +
                " | Status: " + (isIssued ? "Issued to " + issuedTo : "Available"));
    }
}

// -------- MAIN CLASS --------
public class LibraryMgmt {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: issueBook(); break;
                case 4: returnBook(); break;
                case 5: searchBook(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // -------- ADD BOOK --------
    static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book Added Successfully!");
    }

    // -------- VIEW BOOKS --------
    static void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available");
            return;
        }

        for (Book b : books) {
            b.display();
        }
    }

    // -------- ISSUE BOOK --------
    static void issueBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book b : books) {

            if (b.id == id && !b.isIssued) {

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                b.isIssued = true;
                b.issuedTo = name;
                b.issueDate = LocalDate.now();

                System.out.println("Book Issued Successfully!");
                return;
            }
        }

        System.out.println("Book not available!");
    }

    // -------- RETURN BOOK --------
    static void returnBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.id == id && b.isIssued) {

                LocalDate returnDate = LocalDate.now();

                long days = Duration.between(
                        b.issueDate.atStartOfDay(),
                        returnDate.atStartOfDay()
                ).toDays();

                double fine = 0;

                if (days > 7) {
                    fine = (days - 7) * 5; // ₹5 per extra day
                }

                System.out.println("Returned after " + days + " days");
                System.out.println("Fine: ₹" + fine);

                b.isIssued = false;
                b.issuedTo = null;
                b.issueDate = null;

                return;
            }
        }

        System.out.println("Invalid Book ID or not issued");
    }

    // -------- SEARCH --------
    static void searchBook() {

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        boolean found = false;

        for (Book b : books) {

            if (b.title.equalsIgnoreCase(title)) {
                b.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found");
        }
    }
}
