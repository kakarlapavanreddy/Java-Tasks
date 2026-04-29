import java.util.*;

// ---------------- CAR CLASS ----------------
class Car {
    private int carId;
    private String brand;
    private double rentPerDay;
    private boolean isAvailable;

    public Car(int carId, String brand, double rentPerDay) {
        this.carId = carId;
        this.brand = brand;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
    }

    public int getCarId() { return carId; }
    public String getBrand() { return brand; }
    public double getRentPerDay() { return rentPerDay; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean status) {
        isAvailable = status;
    }

    public void display() {
        System.out.println(carId + " - " + brand + " - ₹" + rentPerDay + "/day - " +
                (isAvailable ? "Available" : "Rented"));
    }
}

// ---------------- CUSTOMER CLASS ----------------
class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }
}

// ---------------- RENTAL CLASS ----------------
class Rental {
    Car car;
    Customer customer;
    int days;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public void display() {
        System.out.println("Car: " + car.getBrand() +
                " | Customer: " + customer.getName() +
                " | Days: " + days);
    }
}

// ---------------- MAIN CLASS ----------------
public class CarRental {

    static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Rental> rentals = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Default data
        cars.add(new Car(1, "Hyundai", 1500));
        cars.add(new Car(2, "Toyota", 2000));
        cars.add(new Car(3, "Honda", 1800));

        int choice;

        do {
            System.out.println("\n===== CAR RENTAL SYSTEM =====");
            System.out.println("1. Add Car");
            System.out.println("2. View All Cars");
            System.out.println("3. View Available Cars");
            System.out.println("4. Rent Car");
            System.out.println("5. Return Car");
            System.out.println("6. View Rentals");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addCar();
                    break;

                case 2:
                    viewAllCars();
                    break;

                case 3:
                    viewAvailableCars();
                    break;

                case 4:
                    rentCar();
                    break;

                case 5:
                    returnCar();
                    break;

                case 6:
                    viewRentals();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    // -------- ADD CAR --------
    static void addCar() {
        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter Rent per Day: ");
        double rent = sc.nextDouble();

        cars.add(new Car(id, brand, rent));
        System.out.println("Car Added Successfully!");
    }

    // -------- VIEW ALL CARS --------
    static void viewAllCars() {
        for (Car c : cars)
            c.display();
    }

    // -------- VIEW AVAILABLE --------
    static void viewAvailableCars() {
        for (Car c : cars) {
            if (c.isAvailable())
                c.display();
        }
    }

    // -------- RENT CAR --------
    static void rentCar() {

        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Car c : cars) {

            if (c.getCarId() == id && c.isAvailable()) {

                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Days: ");
                int days = sc.nextInt();

                Customer cust = new Customer(rentals.size() + 1, name);
                Rental r = new Rental(c, cust, days);

                rentals.add(r);
                c.setAvailable(false);

                double total = days * c.getRentPerDay();

                System.out.println("Car Rented Successfully!");
                System.out.println("Total Cost: ₹" + total);
                return;
            }
        }

        System.out.println("Car Not Available!");
    }

    // -------- RETURN CAR --------
    static void returnCar() {

        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();

        Iterator<Rental> it = rentals.iterator();

        while (it.hasNext()) {
            Rental r = it.next();

            if (r.car.getCarId() == id) {
                r.car.setAvailable(true);
                it.remove();

                System.out.println("Car Returned Successfully!");
                return;
            }
        }

        System.out.println("Invalid Car ID!");
    }

    // -------- VIEW RENTALS --------
    static void viewRentals() {

        if (rentals.isEmpty()) {
            System.out.println("No Active Rentals");
        } else {
            for (Rental r : rentals)
                r.display();
        }
    }
}