import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id + " Name: " + name);
    }
}

public class ListDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        LinkedList<String> actions = new LinkedList<>();

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Show Recent Actions");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // 🔥 FIX (consume newline)

                System.out.print("Enter Name: ");
                String name = sc.nextLine(); // 🔥 FIX (full name)

                students.add(new Student(id, name));
                actions.addFirst("Added: " + name);

                System.out.println("Student Added");
            }

            else if (choice == 2) {

                if (students.isEmpty()) {
                    System.out.println("No Students Found");
                } else {
                    for (Student s : students) {
                        s.display();
                    }
                }
            }

            else if (choice == 3) {

                System.out.print("Enter ID to remove: ");
                int id = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < students.size(); i++) {

                    if (students.get(i).id == id) {

                        actions.addFirst("Removed: " + students.get(i).name);
                        students.remove(i);
                        found = true;

                        System.out.println("Student Removed");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student Not Found");
                }
            }

            else if (choice == 4) {

                if (actions.isEmpty()) {
                    System.out.println("No Actions Yet");
                } else {
                    System.out.println("Recent Actions:");

                    // 🔥 Limit to last 5 actions (extra improvement)
                    int count = 0;
                    for (String act : actions) {
                        System.out.println(act);
                        count++;
                        if (count == 5) break;
                    }
                }
            }

        } while (choice != 5);

        sc.close();
    }
}