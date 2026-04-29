import java.util.*;

// ---------------- PATIENT CLASS ----------------
class Patient {
    private int id;
    private String name;
    private String type; // InPatient / OutPatient
    private int days;    // only for inpatient
    private double bill;
    private boolean isAdmitted;

    public Patient(int id, String name, String type, int days) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.days = days;
        this.isAdmitted = true;
        calculateBill();
    }

    // -------- BILL CALCULATION --------
    public void calculateBill() {
        if (type.equalsIgnoreCase("InPatient")) {
            bill = days * 2000; // ₹2000 per day
        } else {
            bill = 500; // fixed OP fee
        }
    }

    public int getId() { return id; }
    public boolean isAdmitted() { return isAdmitted; }

    public void discharge() {
        isAdmitted = false;
    }

    public void display() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Type: " + type +
                " | Bill: ₹" + bill +
                " | Status: " + (isAdmitted ? "Admitted" : "Discharged"));
    }
}

// ---------------- MAIN CLASS ----------------
public class HospitalApp {

    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. View Admitted Patients");
            System.out.println("4. Discharge Patient");
            System.out.println("5. Search Patient");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewAll();
                    break;

                case 3:
                    viewAdmitted();
                    break;

                case 4:
                    dischargePatient();
                    break;

                case 5:
                    searchPatient();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // -------- ADD PATIENT --------
    static void addPatient() {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("1. InPatient");
        System.out.println("2. OutPatient");
        int typeChoice = sc.nextInt();

        String type;
        int days = 0;

        if (typeChoice == 1) {
            type = "InPatient";
            System.out.print("Enter Days: ");
            days = sc.nextInt();
        } else if (typeChoice == 2) {
            type = "OutPatient";
        } else {
            System.out.println("Invalid Type!");
            return;
        }

        patients.add(new Patient(id, name, type, days));
        System.out.println("Patient Added Successfully!");
    }

    // -------- VIEW ALL --------
    static void viewAll() {
        if (patients.isEmpty()) {
            System.out.println("No Patients Found");
        } else {
            for (Patient p : patients)
                p.display();
        }
    }

    // -------- VIEW ADMITTED --------
    static void viewAdmitted() {
        for (Patient p : patients) {
            if (p.isAdmitted())
                p.display();
        }
    }

    // -------- DISCHARGE --------
    static void dischargePatient() {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.getId() == id && p.isAdmitted()) {
                p.discharge();
                System.out.println("Patient Discharged Successfully!");
                return;
            }
        }

        System.out.println("Patient Not Found or Already Discharged");
    }

    // -------- SEARCH --------
    static void searchPatient() {

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.getId() == id) {
                p.display();
                return;
            }
        }

        System.out.println("Patient Not Found");
    }
}