import java.util.HashMap;
import java.util.Scanner;

// -------------------- BOOK CLASS --------------------
class Book {
    int id;
    String name;
    boolean isIssued;
    String issuedTo;
    String phone;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.isIssued = false;
        this.issuedTo = null;
        this.phone = null;
    }
}

// -------------------- LIBRARY CLASS --------------------
class Library {

    HashMap<Integer, Book> books = new HashMap<>();

    // Add Book
    void addBook(int id, String name) {
        if (books.containsKey(id)) {
            System.out.println("Book ID already exists!");
            return;
        }

        books.put(id, new Book(id, name));
        System.out.println("Book added successfully!");
    }

    // View Books
    void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available");
            return;
        }

        System.out.println("\nBooks List:");
        for (Book b : books.values()) {
            if (b.isIssued) {
                System.out.println(b.id + " - " + b.name +
                        " [Issued to " + b.issuedTo + "]");
            } else {
                System.out.println(b.id + " - " + b.name + " [Available]");
            }
        }
    }

    // 🔥 Issue Book by Book Name + User Name + Phone
    void issueBook(String bookName, String user, String phone) {

        boolean found = false;

        for (Book b : books.values()) {

            if (b.name.equalsIgnoreCase(bookName)) {

                if (b.isIssued) {
                    System.out.println("Book already issued!");
                    return;
                }

                b.isIssued = true;
                b.issuedTo = user;
                b.phone = phone;

                System.out.println("Book issued to " + user);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // 🔥 Return Book by Book Name + User Name
    void returnBook(String bookName, String user) {

        boolean found = false;

        for (Book b : books.values()) {

            if (b.isIssued &&
                b.name.equalsIgnoreCase(bookName) &&
                b.issuedTo.equalsIgnoreCase(user)) {

                b.isIssued = false;
                b.issuedTo = null;
                b.phone = null;

                System.out.println("Book returned: " + b.name);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No matching record found!");
        }
    }
}

// -------------------- MAIN CLASS --------------------
public class LibrarySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        int choice;

        do {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book (Name + User)");
            System.out.println("4. Return Book (Name + User)");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();

                    lib.addBook(id, name);
                    break;

                case 2:
                    lib.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book Name: ");
                    String bookName = sc.nextLine();

                    System.out.print("Enter User Name: ");
                    String user = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    lib.issueBook(bookName, user, phone);
                    break;

                case 4:
                    System.out.print("Enter Book Name: ");
                    String returnBook = sc.nextLine();

                    System.out.print("Enter User Name: ");
                    String returnUser = sc.nextLine();

                    lib.returnBook(returnBook, returnUser);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}