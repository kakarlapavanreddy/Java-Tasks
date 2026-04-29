class Mobile {

    private int volume;
    private int brightness;

    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100)
            this.volume = volume;
        else
            System.out.println("Invalid Volume!");
    }

    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100)
            this.brightness = brightness;
        else
            System.out.println("Invalid Brightness!");
    }

    public void display() {
        System.out.println("Volume: " + volume);
        System.out.println("Brightness: " + brightness);
    }
}

public class MobileTest {
    public static void main(String[] args) {

        Mobile m = new Mobile();

        m.setVolume(80);
        m.setBrightness(120); // invalid

        m.display();
    }
}