enum OrderStatus {
    PLACED, SHIPPED, DELIVERED, CANCELLED
}

class Order {

    // Instance variables
    int orderId;
    String productName;
    double price;
    OrderStatus status;

    // Constructor
    Order(int orderId, String productName, double price, OrderStatus status) {
        this.orderId = orderId;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    // Method to update status
    void updateStatus(OrderStatus newStatus) {
        status = newStatus;
    }

    // Method to display order details
    void display() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Product: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Status: " + status);
        System.out.println("----------------------");
    }
}

public class EnumExample {

    public static void main(String[] args) {

        // Creating objects using constructor
        Order o1 = new Order(101, "Laptop", 75000, OrderStatus.PLACED);
        Order o2 = new Order(102, "Mobile", 30000, OrderStatus.SHIPPED);

        // Display initial data
        o1.display();
        o2.display();

        // Updating status using method
        o1.updateStatus(OrderStatus.DELIVERED);
        o2.updateStatus(OrderStatus.CANCELLED);

        // Display updated data
        System.out.println("After Status Update:");
        o1.display();
        o2.display();
    }
}