import java.util.Scanner;

interface Payment {
    void pay(double amount);
}

class CreditCard implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UPI implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class NetBanking implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Net Banking");
    }
}

public class PaymentSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Credit Card\n2. UPI\n3. Net Banking");
        int choice = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        Payment p;

        if (choice == 1)
            p = new CreditCard();
        else if (choice == 2)
            p = new UPI();
        else
            p = new NetBanking();

        p.pay(amount);

        sc.close();
    }
}