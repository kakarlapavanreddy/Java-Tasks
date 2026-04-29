import java.io.*;

// Serializable class
class Employee implements Serializable {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class SerializationDemo {

    public static void main(String[] args) {

        try {
            // Writing object
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream("emp.txt"));

            Employee e = new Employee(1, "Pavan");
            oos.writeObject(e);
            oos.close();

            System.out.println("Object Saved");

            // Reading object
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("emp.txt"));

            Employee e2 = (Employee) ois.readObject();
            System.out.println("ID: " + e2.id + " Name: " + e2.name);

            ois.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}