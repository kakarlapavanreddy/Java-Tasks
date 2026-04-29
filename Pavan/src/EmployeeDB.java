import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// -------- EMPLOYEE CLASS --------
class Employee {
    int id;
    String name;
    String designation;
    double basicSalary;

    double hra;
    double pf;
    double tax;
    double netSalary;

    // Constructor
    Employee(int id, String name, String designation, double basicSalary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.basicSalary = basicSalary;
        calculateSalary();
    }

    // Salary calculation
    void calculateSalary() {
        hra = basicSalary * 0.20;   // 20% HRA
        pf = basicSalary * 0.10;    // 10% PF
        tax = basicSalary * 0.05;   // 5% Tax

        netSalary = basicSalary + hra - pf - tax;
    }

    void display() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Designation: " + designation +
                " | Basic: ₹" + basicSalary +
                " | HRA: ₹" + hra +
                " | PF: ₹" + pf +
                " | Tax: ₹" + tax +
                " | Net: ₹" + netSalary);
    }
}

// -------- MAIN CLASS --------
public class EmployeeDB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // HashMap: ID → Employee
        HashMap<Integer, Employee> map = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE DATABASE =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                if (map.containsKey(id)) {
                    System.out.println("Employee ID already exists!");
                    continue;
                }

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Designation: ");
                String des = sc.nextLine();

                System.out.print("Enter Basic Salary: ");
                double salary = sc.nextDouble();

                Employee emp = new Employee(id, name, des, salary);
                map.put(id, emp);

                System.out.println("Employee Added Successfully!");
            }

            else if (choice == 2) {

                if (map.isEmpty()) {
                    System.out.println("No Employees Found");
                } else {
                    for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
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
                    System.out.println("Employee Not Found");
                }
            }

            else if (choice == 4) {

                System.out.print("Enter ID to Remove: ");
                int id = sc.nextInt();

                if (map.containsKey(id)) {
                    map.remove(id);
                    System.out.println("Employee Removed");
                } else {
                    System.out.println("Employee Not Found");
                }
            }

        } while (choice != 5);

        sc.close();
    }
}