abstract class Patient {

    abstract void calculateBill();
}

class InPatient extends Patient {

    void calculateBill() {
        System.out.println("Bill: 5000 (Room + Treatment)");
    }
}

class OutPatient extends Patient {

    void calculateBill() {
        System.out.println("Bill: 500 (Consultation)");
    }
}

public class HospitalBill {
    public static void main(String[] args) {

        Patient p;

        p = new InPatient();
        p.calculateBill();

        p = new OutPatient();
        p.calculateBill();
    }
}