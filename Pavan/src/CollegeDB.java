import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// -------- STUDENT CLASS --------
class Student {
    int id;
    String name;
    String branch;
    int year;

    // Constructor
    Student(int id, String name, String branch, int year) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.year = year;
    }

    // Display method
    void display() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Branch: " + branch +
                " | Year: " + year);
    }
}

// -------- MAIN CLASS --------
public class CollegeDB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // HashMap: Key = ID, Value = Student Object
        HashMap<Integer, Student> map = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== COLLEGE DATABASE =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                // Check duplicate ID
                if (map.containsKey(id)) {
                    System.out.println("Student ID already exists!");
                    continue;
                }

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Branch: ");
                String branch = sc.nextLine();

                System.out.print("Enter Year: ");
                int year = sc.nextInt();

                // Create object
                Student s = new Student(id, name, branch, year);

                // Store in HashMap
                map.put(id, s);

                System.out.println("Student Added Successfully!");
            }

            else if (choice == 2) {

                if (map.isEmpty()) {
                    System.out.println("No Students Found");
                } else {
                    for (Map.Entry<Integer, Student> entry : map.entrySet()) {
                        entry.getValue().display();
                    }
                }
            }

            else if (choice == 3) {

                System.out.print("Enter ID to Search: ");
                int id = sc.nextInt();

                if (map.containsKey(id)) {
                    map.get(id).display();
                } else {
                    System.out.println("Student Not Found");
                }
            }

            else if (choice == 4) {

                System.out.print("Enter ID to Remove: ");
                int id = sc.nextInt();

                if (map.containsKey(id)) {
                    map.remove(id);
                    System.out.println("Student Removed");
                } else {
                    System.out.println("Student Not Found");
                }
            }

        } while (choice != 5);

        sc.close();
    }
}