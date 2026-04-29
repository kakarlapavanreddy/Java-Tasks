import java.util.Scanner;

abstract class Food {
    abstract void prepareFood();
    abstract double calculatePrice(int qty);
}

class Pizza extends Food {

    void prepareFood() {
        System.out.println("Preparing Pizza...");
    }

    double calculatePrice(int qty) {
        return qty * 200;
    }
}

class Burger extends Food {

    void prepareFood() {
        System.out.println("Preparing Burger...");
    }

    double calculatePrice(int qty) {
        return qty * 100;
    }
}

public class FoodOrder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Pizza\n2. Burger");
        int choice = sc.nextInt();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        Food f;

        if (choice == 1)
            f = new Pizza();
        else
            f = new Burger();

        f.prepareFood();

        double total = f.calculatePrice(qty);
        System.out.println("Total Price: " + total);

        sc.close();
    }
}