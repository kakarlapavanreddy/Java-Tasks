interface Switchable {

    void turnOn();
    void turnOff();
}

class Fan implements Switchable {

    public void turnOn() {
        System.out.println("Fan ON");
    }

    public void turnOff() {
        System.out.println("Fan OFF");
    }
}

class Light implements Switchable {

    public void turnOn() {
        System.out.println("Light ON");
    }

    public void turnOff() {
        System.out.println("Light OFF");
    }
}

public class DeviceTest {
    public static void main(String[] args) {

        Switchable s;

        s = new Fan();
        s.turnOn();

        s = new Light();
        s.turnOff();
    }
}