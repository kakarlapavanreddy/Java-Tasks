public class MethodOverloading {

    int x, y; // instance variables

    // 🔹 DEFAULT CONSTRUCTOR
    MethodOverloading() {
        System.out.println("Default Constructor Called");
        x = 0;
        y = 0;
    }

    // 🔹 PARAMETERIZED CONSTRUCTOR
    MethodOverloading(int a, int b) {
        System.out.println("Parameterized Constructor Called");
        x = a;
        y = b;
    }

    // Method 1
    int add(int a, int b) {
        return a + b;
    }

    // Method 2
    double add(double a, double b) {
        return a + b;
    }

    // Method 3
    int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {

        // 🔹 Using Default Constructor
        MethodOverloading obj1 = new MethodOverloading();

        // 🔹 Using Parameterized Constructor
        MethodOverloading obj2 = new MethodOverloading(10, 20);

        // 🔹 Calling methods
        System.out.println("Int Add: " + obj1.add(10, 20));
        System.out.println("Double Add: " + obj1.add(10.5, 20.5));
        System.out.println("3 Numbers Add: " + obj1.add(5, 10, 15));

        // Using constructor values
        System.out.println("Constructor Values Add: " + obj2.add(obj2.x, obj2.y));
    }
}